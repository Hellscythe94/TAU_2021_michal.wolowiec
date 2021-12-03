#Scenario to check if providing an email that is not registered will bring us to the register page
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

logger.info("Going to empik.com logging page in " + driver.name)
temp = driver.find_element(By.XPATH, "/html/body/header/div/div/div[5]/nav/ul[2]/li[1]")
temp.click()

temp = driver.find_element(By.ID,"user-email")
temp.send_keys("example@email.com")
temp = driver.find_element(By.XPATH,"/html/body/main/div/div/div/form/div[4]/button")
temp.click()


try:
    cookies = WebDriverWait(driver, 10).until(
        EC.presence_of_element_located((By.XPATH,"/html/body/main/div/div/div/div/div[1]/h2"))
        )
finally:
    temp = driver.find_element(By.XPATH,"/html/body/main/div/div/div/div/div[1]/h2")

if temp.text == "Rejestracja konta Empik Premium Free":
    logger.info("Test successfull")
else:
    logger.info("Test failed.")


driver.close()
