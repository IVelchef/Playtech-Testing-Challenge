# Overview

This repository showcases a personal project focused on automating the core functionalities of a Bingo web application. The project serves as a hands-on exercise in web UI automation using Selenium WebDriver and JUnit 5. The main goal is to practice creating end-to-end tests for user authentication, gameplay interactions, and result validation.

## Repository Structure

1. **Login Automation**  
   This module automates the login process for the Bingo application. Key functionalities include:
   - Inputting user credentials.
   - Handling the "Accept Terms and Conditions" step.
   - Verifying a successful login before proceeding.

2. **Gameplay Automation**  
   The gameplay module focuses on automating core Bingo features:
   - Buying game tickets.
   - Monitoring the countdown timer until the game starts.
   - Matching drawn numbers with numbers on the game cards.
   - Ensuring that the matching numbers are marked correctly on the cards.
   - Completing the game after validating the results.

3. **JUnit Test: Bingo Number Matching Validation**  
   This test verifies the proper functionality of the automated gameplay:
   - Logs in with test credentials.
   - Simulates the Bingo game flow, including ticket purchase and number drawing.
   - Asserts that at least 20 numbers are marked correctly on the cards.


## Highlights

### Learning Objectives
- **Web UI Automation:** Practice using Selenium WebDriver to interact with dynamic elements.
- **Test Design:** Develop robust and reusable test structures with JUnit 5.
- **Dynamic Waiting Strategies:** Handle asynchronous elements using WebDriverWait.
- **Assertions and Validations:** Confirm the correctness of automated actions with meaningful assertions.

### Technical Notes
- Flexible selectors (XPath and CSS) are used for targeting web elements.
- Dynamic waiting ensures stable test execution, even for time-sensitive scenarios like countdowns.
- The project demonstrates effective logging and error handling.

## Requirements

This project is purely exploratory and does not follow specific business requirements. The following tasks were designed based on common gameplay flows in Bingo applications:

### Scenario 1: Bingo Gameplay
- Log in with test user credentials.
- Select a game and purchase tickets.
- Wait for the countdown timer to reach zero and start the game.
- Monitor the numbers drawn and match them with the cards.
- Ensure that at least 20 numbers are correctly marked.

### Scenario 2: Timer Validation and Logging
- Validate the proper functionality of the timer before game start.
- Log all drawn numbers for traceability.

## Conclusion

This repository represents a learning project aimed at practicing automation testing techniques in a web application context. While the Bingo application used here is fictional, the approaches and methods can be applied to real-world testing scenarios. The clear structure and documentation make it a valuable resource for understanding web automation practices.
