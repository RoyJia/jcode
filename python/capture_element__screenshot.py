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

driver.save_screenshot("aaaaa.png")


# get snapshot for wizard
element = driver.find_element_by_xpath("//section[@id='WizardHero']");
location = element.location;
size = element.size;

x = location['x'];
y = location['y'];
width = location['x']+size['width'];
height = location['y']+size['height'];

print(f"x: {x}, y: {y}, width: {width}, height: {height}")

size = 1200, 800

im = Image.open('aaaaa.png')
im.thumbnail(size)
print(f"im size: {im.size}")
im = im.crop((int(x), int(y), int(width), int(height)))
im.save('wizard.png')


driver.quit()