import os
import time
from sys import platform
from PIL import Image

from selenium import webdriver
from selenium.webdriver.chrome.options import Options

#########################################################################################################
# scraper page and capture screenshot
opts = Options()
chromedriver = os.path.abspath(os.path.join(os.path.dirname(__file__), "resources/chromedriver/mac/chromedriver"))
# if we want to capture full page as screenshot, selenium is only working on headless mode
opts.add_argument('--headless')
opts.add_argument('--window-size=1200,800')
driver = webdriver.Chrome(executable_path=chromedriver, options=opts)

driver.get("http://www.expedia.com")

aaaaapng = os.path.abspath(os.path.join(os.path.dirname(__file__), "temp_imgs/aaaaa.png"))
driver.save_screenshot(aaaaapng)


# get snapshot for wizard
element = driver.find_element_by_xpath("//section[@id='WizardHero']");
location = element.location;
size = element.size;

x = location['x'];
y = location['y'];
width = location['x']+size['width'];
height = location['y']+size['height'];

print(f"x: {x}, y: {y}, width: {width}, height: {height}")
print(element.rect)

size = 1200, 800

im = Image.open(aaaaapng)
im.thumbnail(size)
print(f"im size: {im.size}")
im = im.crop((int(x), int(y), int(width), int(height)))
wizardpng = os.path.abspath(os.path.join(os.path.dirname(__file__), "temp_imgs/wizard.png"))
im.save(wizardpng)


driver.quit()