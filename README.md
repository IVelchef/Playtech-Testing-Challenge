### Project Description
This project focuses on automated testing for the "Bingo" web application. It includes several Java classes that implement different functionalities, such as logging in, starting the game, and marking numbers. The tests are developed using **JUnit 5**, and interaction with the web pages is achieved through **Selenium WebDriver**.

### Main Components
1. **BingoHomePage**  
   This is the base class for the Bingo pages. It defines the base URL of the application and serves as a foundation for other page classes.

2. **BingoPage**  
   This class implements the core functionality of the game:
   - Buying tickets.
   - Monitoring the timer until the game starts.
   - Marking numbers matching the drawn ones.
   - Verifying the count of marked numbers.

3. **LoginPageBingo**  
   This class handles user login by submitting a username and password and clicking the accept button for terms and conditions.

4. **Test Class (testBingoNumberCheck)**  
   The main idea of this test is to confirm that after the numbers are drawn, the test correctly searches for matches between the drawn numbers and those on the cards. It ensures that the matches are accurately marked on the cards. The test:
   - Logs the user into the system.
   - Starts the game.
   - Verifies that at least 20 numbers were correctly marked.

### Key Highlights
- **Use of WebDriverWait:** Ensures page elements are visible or ready for interaction before proceeding.
- **Flexible Selectors:** XPath and CSS selectors are used for precise element targeting.
- **Dynamic Waiting:** Handles time intervals between the drawing of numbers.
- **JUnit Assertions:** Verify the correctness of marked numbers.
