#Scenario to get the phone number for the empik support
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as firefoxService
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
import logging

# Set logger
logger  = logging.getLogger("site1")
logger.setLevel(logging.INFO)
rf = logging.StreamHandler()
rf.setLevel(logging.DEBUG)
formatter = logging.Formatter('%(asctime)s - %(name)s - %(levelname)s - %(message)s')
rf.setFormatter(formatter)
logger.addHandler(rf)

chFire = firefoxService('../../drivers/firefox/geckodriver')
driver = webdriver.Firefox(service=chFire)


driver.maximize_window()
logger.info("Going to empik.com in " + driver.name)
driver.get("https://www.empik.com/")

logger.info("Going to empik.com support page in " + driver.name)
temp = driver.find_element(By.XPATH, "/html/body/header/div/div/div[1]/a[7]")
temp.click()


try:
    cookies = WebDriverWait(driver, 10).until(
        EC.presence_of_element_located((By.XPATH,"/html/body/main/section[2]/div/div[2]/div[1]/div"))
        )
finally:
    temp = driver.find_element(By.XPATH,"/html/body/main/section[2]/div/div[2]/div[1]/div")

logger.info("The phone number for the empik support is " + temp.text)


driver.close()
