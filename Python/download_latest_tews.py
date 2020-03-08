import os
import csv
import wget

from selenium import webdriver
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.common.action_chains import ActionChains


opts = Options()
chromedriver = os.path.abspath(os.path.join(os.path.dirname(__file__), "resources/chromedriver/mac/chromedriver"))
opts.add_argument('--headless')

driver = webdriver.Chrome(executable_path=chromedriver, options=opts)

episodes_csv = os.path.abspath(os.path.join(os.path.dirname(__file__), "/Users/rjia/Documents/bbc/the_english_we_speak/tews_episodes.csv"))

with open(episodes_csv, 'r') as read_file:
    reader = list(csv.reader(read_file))

# open url http://www.bbc.co.uk/learningenglish/english/features/the-english-we-speak
driver.get("http://www.bbc.co.uk/learningenglish/english/features/the-english-we-speak")

# get the latest episode element"
episode_ele = driver.find_element_by_css_selector("div#bbcle-content div.widget-bbcle-coursecontentlist div.text h2 a")

# get episode page
if episode_ele:
    actions = ActionChains(driver)
    actions.move_to_element(episode_ele).click().perform()


# validate we are episode page now
heading_tews_elem = driver.find_element_by_id('heading-the-english-we-speak')
assert heading_tews_elem is not None

url = driver.current_url  
episode_id = str(url).split('/')[-1]
episode_name = driver.find_element_by_css_selector('div#heading-intermediate-level + div > h3').text
episode_info = [episode_name, episode_id, url]

if episode_info not in reader:

    # audio download button ".bbcle-download-linkparent-extension-mp3"
    audio_download_btn = driver.find_element_by_css_selector('a.bbcle-download-extension-mp3')
    if audio_download_btn:
        audio_url = audio_download_btn.get_attribute('href')
        wget.download(audio_url, f"/Users/rjia/Documents/bbc/the_english_we_speak/{episode_id}_{episode_name}.mp3")

    # pdf download button ".bbcle-download-linkparent-extension-pdf"
    pdf_download_btn = driver.find_element_by_css_selector('a.bbcle-download-extension-pdf')
    if pdf_download_btn:
        pdf_url = pdf_download_btn.get_attribute('href')
        wget.download(pdf_url, f"/Users/rjia/Documents/bbc/the_english_we_speak/{episode_id}_{episode_name}.pdf")

    print('\n')
    # give it a file to record what episodes we had already 
    reader.insert(0, episode_info)
    with open(episodes_csv, 'w') as write_file:
        writer = csv.writer(write_file)
        for line in reader:
            writer.writerow(line)

    read_file.close()
    write_file.close()

    print(f"{', '.join(episode_info)} is downloaded this time")
else:
    print(f"{str(episode_info)} is existed already")


driver.quit()