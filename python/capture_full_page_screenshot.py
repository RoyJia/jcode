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

current_height = driver.execute_script("return document.body.clientHeight")
print("this is current_height: {current_height}".format(current_height=current_height))

current_width = driver.execute_script("return document.body.clientWidth")
print("this is current_width: {current_width}".format(current_width=current_width))

print(driver.get_window_size())
driver.save_screenshot("homepage_before_height.png")

driver.set_window_size(1200, current_height)
print(driver.get_window_size())
# it would be better that time.sleep(2) here to ensure the page full loaded
time.sleep(2)
driver.save_screenshot("homepage_after_height.png")

driver.close()

#########################################################################################################
# convert png to jpg and point size
try:
    image = Image.open("homepage_after_heightssss.png")
except FileNotFoundError:
    print(f"file homepage_after_heightssss.png is not exist")
else:
    image.convert('RGB').save('homepage_after_height.jpg')
    os.remove("homepage_after_height.png")
