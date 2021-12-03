#Scenario to check how many job offers there are for a specific job and place.

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

job = "QA engineer"
place = "Szczecin"


driver.maximize_window()
logger.info("Going to pracuj.pl in " + driver.name)
driver.get("https://www.pracuj.pl/")

# Wait for the cookies popup and click on it 
logger.info("Agreeing to cookies")
try:
    cookies = WebDriverWait(driver, 10).until(
        EC.presence_of_element_located((By.XPATH,"/html/body/div[2]/div/div/div/div[1]/div[3]/button"))
        )
finally:
    logger.info("Clicking agree")
    driver.find_element(By.XPATH,"/html/body/div[2]/div/div/div/div[1]/div[3]/button").click()

# Wait till the inputs are available
try:
    clickable = WebDriverWait(driver, 10).until(
        EC.element_to_be_clickable((By.XPATH,"/html/body/main/div[1]/div/div/div[3]/form/div[1]/div[2]/div/div/input"))
    )
finally:
    logger.info("Elements are interactable")


jobInput = driver.find_element(By.XPATH,"/html/body/main/div[1]/div/div/div[3]/form/div[1]/div[2]/div/div/input")
placeInput = driver.find_element(By.XPATH,"/html/body/main/div[1]/div/div/div[3]/form/div[1]/div[3]/div/div/input")
searchButton = driver.find_element(By.XPATH,"/html/body/main/div[1]/div/div/div[3]/form/div[1]/div[5]/button")
jobInput.send_keys(job)
placeInput.send_keys(place)
searchButton.click()

jobsAvailable = ""
try:
    cookies = WebDriverWait(driver, 10).until(
        EC.presence_of_element_located((By.XPATH,"/html/body/div[1]/div[2]/div[6]/div/span/span"))
        )
finally:
    jobsAvailable = driver.find_element(By.XPATH,"/html/body/div[1]/div[2]/div[6]/div/span/span")


logger.info(driver.name + " - There are " + jobsAvailable.text + " for " + job + " in " + place)
driver.close()
