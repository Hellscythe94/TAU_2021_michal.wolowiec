#Scenario to check how on average does a specific job pay

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


driver.maximize_window()
logger.info("Going to zarobki.pracuj.pl in " + driver.name)
driver.get("https://zarobki.pracuj.pl/")

# Wait for the cookies popup and click on it 
logger.info("Agreeing to cookies")
try:
    cookies = WebDriverWait(driver, 10).until(
        EC.presence_of_element_located((By.XPATH,"/html/body/div[4]/div/div/div[1]/div[3]/button"))
        )
finally:
    logger.info("Clicking agree")
    driver.find_element(By.XPATH,"/html/body/div[4]/div/div/div[1]/div[3]/button").click()

# Wait till the inputs are available
try:
    clickable = WebDriverWait(driver, 10).until(
        EC.element_to_be_clickable((By.XPATH, "/html/body/div[2]/div/div/div/form/div/div[1]/span/input[2]"))
    )
finally:
    logger.info("Elements are interactable")


jobInput = driver.find_element(By.XPATH, "/html/body/div[2]/div/div/div/form/div/div[1]/span/input[2]")
searchButton = driver.find_element(By.XPATH,"/html/body/div[2]/div/div/div/form/div/div[2]/input")
jobInput.send_keys(job)
searchButton.click()

averageSalary = ""
try:
    cookies = WebDriverWait(driver, 10).until(
        EC.presence_of_element_located((By.XPATH,"/html/body/div[2]/main/div[1]/div/div/div[1]/div[1]/div[1]/span"))
        )
finally:
    averageSalary = driver.find_element(By.XPATH,"/html/body/div[2]/main/div[1]/div/div/div[1]/div[1]/div[1]/span")


logger.info(driver.name + " - The average salary " + " for " + job + " is " + averageSalary.text)
driver.close()
