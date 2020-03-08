import os
import time
from sys import platform
from PIL import Image

from selenium import webdriver
from selenium.webdriver.chrome.options import Options

#########################################################################################################
# scraper page and capture screenshot
opts = Options()
# if we want to capture full page as screenshot, selenium is only working on headless mode
opts.add_argument('--headless')
opts.add_argument('--window-size=1200,800')
driver = webdriver.Chrome(executable_path='resources/chromedriver/mac/chromedriver', options=opts)

driver.get("http://www.expedia.com")

div_ele = driver.find_element_by_xpath('//*[@id="wizard-tabs"]')


flight_tab_btn = driver.find_element_by_xpath('//button[@id="tab-flight-tab-hp"]')

print(flight_tab_btn.text)

print("------------------------")

parent1 = flight_tab_btn.find_element_by_xpath('..')

print(parent1.tag_name)
parent2 = flight_tab_btn.find_element_by_xpath(".//ancestor::li")
print(parent2.tag_name)

print("------------------------")
child_ele = flight_tab_btn.find_element_by_xpath(".//ancestor::li").find_element_by_xpath('.//button[@id="tab-car-tab-hp"]')

child_ele = flight_tab_btn.find_element_by_xpath(".//ancestor::li").find_element_by_xpath('.//button[@id="tab-flight-tab-hp"]')

print(child_ele.text)


# current_height = driver.execute_script("return document.body.clientHeight")
# print("this is current_height: {current_height}".format(current_height=current_height))

# current_width = driver.execute_script("return document.body.clientWidth")
# print("this is current_width: {current_width}".format(current_width=current_width))

# print(driver.get_window_size())
# driver.save_screenshot("temp_imgs/homepage_before_height.png")

# driver.set_window_size(1200, current_height)
# print(driver.get_window_size())
# # it would be better that time.sleep(2) here to ensure the page full loaded
# time.sleep(2)
# driver.save_screenshot("temp_imgs/homepage_after_height.png")

driver.close()

#########################################################################################################
# convert png to jpg and point size
# try:
#     image = Image.open("homepage_after_heightssss.png")
# except FileNotFoundError:
#     print(f"file homepage_after_heightssss.png is not exist")
# else:
#     image.convert('RGB').save('temp_imgs/homepage_after_height.jpg')
#     os.remove("homepage_after_height.png")
