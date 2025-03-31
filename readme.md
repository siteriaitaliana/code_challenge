Instruction made using a MAcbook pro

brew install maven

java and sdk installed through the vscode IDE

Open the terminal and navigate to your project directory:

Compile and run the project using Maven:
mvn clean install
mvn compile
mvn clean test

(Optional) Run Tests with TestNG:

If you use TestNG, create a test class and an XML configuration file (testng.xml) to define your test suite. Then, run the tests with:
mvn test

Make sure you have google chrome installed version 134 as selenium-devtools-v134 and chrome driver are in this version

1. Set Up Selenium Grid
   Start the Selenium Grid Hub
   Run the following command to start the Selenium Grid Hub:
   java -jar selenium-server-<version>.jar standalone
   You can verify the setup by navigating to http://localhost:4444/ui in your browser.

Verify Parallel Execution
Open the Selenium Grid UI at http://localhost:4444/ui to monitor the test execution.
You should see tests running in parallel on both Chrome and Firefox.

Install node and npm

Install Appium
Install Appium globally using npm:

appium
npm install -g appium

Install Appium Doctor (Optional)
Appium Doctor helps verify that all dependencies are correctly installed:
npm install -g appium-doctor
Run Appium Doctor to check your setup:
appium-doctor

Install Android studio, android sdk and command line tools

Ensure that the Android SDK is correctly configured and the ANDROID_HOME and ANDROID_SDK_ROOT environment variables are set.

4. Start an Android Emulator
   Open Android Studio.
   Go to Tools > Device Manager.
   Create a new virtual device (e.g., Pixel 5).
   Start the emulator.
   Alternatively, start the emulator from the terminal:
   emulator -avd <emulator_name>

appium driver install uiautomator2

Start Appium Server
Start the Appium server from the terminal:
appium

The server will start on http://localhost:4723 by default.
