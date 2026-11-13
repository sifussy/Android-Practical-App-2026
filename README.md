# prac_app – Traffic Light Android App

GMI Diploma practical test (Question 1), built in Android Studio with **Java + XML**.

The app has three buttons: **YELLOW**, **RED** and **GREEN**. Clicking one changes the background colour and shows a message:

| Button | Background | Message  |
|--------|------------|----------|
| YELLOW | Yellow     | CAUTION! |
| RED    | Red        | STOP!    |
| GREEN  | Green      | GO!      |

- The buttons stay centred in both portrait and landscape.
- The selected colour and message are kept when the screen rotates (`onSaveInstanceState`).
- Each button has a black border so it stays visible on a matching background.

## Main files
- `app/src/main/res/layout/activity_main.xml` – layout
- `app/src/main/java/com/example/myapplication/MainActivity.java` – button logic
- `app/src/main/res/drawable/btn_*.xml` – button shapes

## Run
Open the folder in Android Studio, let Gradle sync, then press **Run** on an emulator or device (min SDK 30).

Student: ILHAM MUNSIF BIN EZWAN (CBS24070563)
