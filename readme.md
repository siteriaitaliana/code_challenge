Test fw created using a Macbook pro.

- Make sure you have Java sdk and Maven setup

- Open the terminal, git checkout and navigate to your project directory

- Make sure you have google chrome installed version 134 as selenium-devtools-v134 chrome driver is for this version

- Start the Selenium Grid Hub with the following command:
  `java -jar ./code_challenge/src/test/java/com/example/driver/selenium-server-4.30.0.jar standalone`
  You can verify the setup by navigating to http://localhost:4444/ui in your browser

- Open the Selenium Grid UI at http://localhost:4444/ui to monitor the test execution.
  You should see tests running in parallel on both Chrome and Firefox.

- Install node and npm

- Install Appium
  `npm install -g appium`

- Install Appium Doctor, helps verify that all dependencies are correctly installed:
  `npm install -g appium-doctor`

- Run Appium Doctor to check your setup:
  appium-doctor

- Install appium-inspector to inspect Android app elements & selectors

- Install Android studio, android sdk and command line tools

- Ensure that the Android SDK is correctly configured and the ANDROID_HOME and ANDROID_SDK_ROOT environment variables are set.

- Start an Android Emulator from Android Studio.
  Alternatively, start the emulator from the terminal:
  emulator -avd <emulator_name>

- appium driver install uiautomator2

- Start Appium Server from the terminal:
  `appium --log-=level debug`
  The server will start on http://localhost:4723 by default.

- Compile and run the project using Maven:
  `mvn clean install`
  `mvn compile`
  `mvn clean test`
  You should see the 3 test run in parallel (Chrome, Firefox and Android in the Android studio emulator - this test the website using an apk webview app that wraps it, present in the repo and installed each time in the device).
