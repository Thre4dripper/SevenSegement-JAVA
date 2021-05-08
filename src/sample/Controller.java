package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller  implements Initializable {
    @FXML
    AnchorPane anchorpane;//Whole Anchor pane
    @FXML
    Pane p1,p2,p3,p4,p5,p6; // 6  panes for 6 seven segment screens
   @FXML
   Polygon p1a,p1b,p1c,p1d,p1e,p1f,p1g;// 7 Segments for 1st screen
   @FXML
   Polygon p2a,p2b,p2c,p2d,p2e,p2f,p2g;// 7 Segments for 2nd screen
   @FXML
   Polygon p3a,p3b,p3c,p3d,p3e,p3f,p3g;// 7 Segments for 3rd screen
   @FXML
   Polygon p4a,p4b,p4c,p4d,p4e,p4f,p4g;// 7 Segments for 4th screen
   @FXML
   Polygon p5a,p5b,p5c,p5d,p5e,p5f,p5g;// 7 Segments for 5th screen
   @FXML
   Polygon p6a,p6b,p6c,p6d,p6e,p6f,p6g;// 7 Segments for 6th screen
    @FXML
    Circle dot1,dot2,dot3,dot4;//small dots that blinks with second
    @FXML
    ColorPicker color;//Color changer of all the displays
    @FXML
    ComboBox type_combo,format_combo;//Combobox for choosing b/w Clock,Stopwatch & timer AND 12/24 hr format changer
     @FXML
    Label firstscr,secondscr,thirdscr;//dynamic labels under the screens that changes when switching between modes


    @FXML Button stopW1,stopW2;//Stopwatch buttons
    @FXML ScrollPane lap_pane;      //Scroll pane
    @FXML VBox lap_box;                 //Vbox for adding new laps vertically

    @FXML Button hrdown,hrup,mindown,minup,secdown,secup;//Buttons for increasing or decreasing Timer values
    @FXML Button timer_btn1, timer_btn2;//Timer buttons for Start/Pause
    @FXML Label timer_label;//Dynamic label for Clock Combobox and Timer Scroll instructions

    /**============================== HERE LIES THE HEART OF THE PROGRAM IN FORM OF VARIABLES =================================**/
    int HH,MM,SS;//for controlling all the screens ,THESE ARE THE NUMBERS THAT SHOWS IN SEVEN SEGMENT DISPLAYS
    int initHH,initMM,initSS;//for initially storing Timer values to show in windows notification
    int switchtype=0;//main variable for switching and controlling b/w modes
    int counter=0;//counter for preventing further usage of some variables
     Paint colour;//COLOR variable

    /**====================== THIS METHOD IS USED FOR APPLYING COLOR TO ALL THE SEVEN SEGMENT DISPLAYS ====================**/
    public void setcolor(){
        colour=Color.valueOf(color.getValue().toString());//simply getting color from color picker and storing it in color variable

        //Applying color to all the segments
        p1a.setFill(colour);p1b.setFill(colour);p1c.setFill(colour);p1d.setFill(colour);p1e.setFill(colour);p1f.setFill(colour);p1g.setFill(colour);
        p2a.setFill(colour);p2b.setFill(colour);p2c.setFill(colour);p2d.setFill(colour);p2e.setFill(colour);p2f.setFill(colour);p2g.setFill(colour);
        p3a.setFill(colour);p3b.setFill(colour);p3c.setFill(colour);p3d.setFill(colour);p3e.setFill(colour);p3f.setFill(colour);p3g.setFill(colour);
        p4a.setFill(colour);p4b.setFill(colour);p4c.setFill(colour);p4d.setFill(colour);p4e.setFill(colour);p4f.setFill(colour);p4g.setFill(colour);
        p5a.setFill(colour);p5b.setFill(colour);p5c.setFill(colour);p5d.setFill(colour);p5e.setFill(colour);p5f.setFill(colour);p5g.setFill(colour);
        p6a.setFill(colour);p6b.setFill(colour);p6c.setFill(colour);p6d.setFill(colour);p6e.setFill(colour);p6f.setFill(colour);p6g.setFill(colour);

        //Applying same color to the boundaries
       p1a.setStroke(colour);p1b.setStroke(colour);p1c.setStroke(colour);p1d.setStroke(colour);p1e.setStroke(colour);p1f.setStroke(colour);p1g.setStroke(colour);
        p2a.setStroke(colour);p2b.setStroke(colour);p2c.setStroke(colour);p2d.setStroke(colour);p2e.setStroke(colour);p2f.setStroke(colour);p2g.setStroke(colour);
        p3a.setStroke(colour);p3b.setStroke(colour);p3c.setStroke(colour);p3d.setStroke(colour);p3e.setStroke(colour);p3f.setStroke(colour);p3g.setStroke(colour);
        p4a.setStroke(colour);p4b.setStroke(colour);p4c.setStroke(colour);p4d.setStroke(colour);p4e.setStroke(colour);p4f.setStroke(colour);p4g.setStroke(colour);
        p5a.setStroke(colour);p5b.setStroke(colour);p5c.setStroke(colour);p5d.setStroke(colour);p5e.setStroke(colour);p5f.setStroke(colour);p5g.setStroke(colour);
        p6a.setStroke(colour);p6b.setStroke(colour);p6c.setStroke(colour);p6d.setStroke(colour);p6e.setStroke(colour);p6f.setStroke(colour);p6g.setStroke(colour);

        //Applying color to the four dots
        dot1.setFill(colour);dot2.setFill(colour);dot3.setFill(colour);dot4.setFill(colour);
        dot1.setStroke(colour);dot2.setStroke(colour);dot3.setStroke(colour);dot4.setStroke(colour);

        //Applying color to the Dynamic labels under all the displays
        firstscr.setTextFill(colour);secondscr.setTextFill(colour);thirdscr.setTextFill(colour);
    }

    /**======================================== METHOD FOR SWITCHING BETWEEN MODES ============================================**/
    public void setType_combo(){
        //when Clock is selected
        if(type_combo.getValue().equals("Clock")){
            counter=0;//resetting counter for clock
            lap_box.getChildren().clear();//clearing stopwatch's lap screen

            timer_label.setFont(Font.font(null, FontWeight.NORMAL,12));//setting dynamic label to 'Format' for clock with some properties
            timer_label.setText("Format");//setting text
            timer_label.setLayoutX(240);//layout X
            timer_label.setTextFill(Color.BLACK);//Color should be black
        format_combo.setDisable(false);//enabling format changing Combobox
        format_combo.setOpacity(1);//and showing it to screen

            //Three dynamic labels under the Screens for clock
            firstscr.setText("Seconds");
            secondscr.setText("Minutes");
            thirdscr.setText("Hours");

            //hiding all the Timer and stopwatch buttons
            hrdown.setOpacity(0);hrup.setOpacity(0);mindown.setOpacity(0);minup.setOpacity(0);secdown.setOpacity(0);secup.setOpacity(0);
            stopW1.setOpacity(0);stopW2.setOpacity(0);
            lap_pane.setOpacity(0);

            //And disabling them as well
            hrdown.setDisable(true);hrup.setDisable(true);mindown.setDisable(true);minup.setDisable(true);secdown.setDisable(true);secup.setDisable(true);
            stopW1.setDisable(true);stopW2.setDisable(true);

            //hiding more of  the Timer and stopwatch buttons And disabling them as well
            timer_btn1.setOpacity(0);
            timer_btn2.setOpacity(0);
            timer_btn1.setDisable(true); timer_btn2.setDisable(true);

            //setting switching variable to 0 for clock
            switchtype=0;Clock();//and here Starts the clock

        }
        //When Stopwatch is selected
        else if(type_combo.getValue().equals("Stopwatch")){
            counter=0;//resetting counter for Stopwatch
            lap_box.getChildren().clear();//and clearing the lap screen

            timer_label.setText("");//there is no need for dynamic label either for format change or Timer instructions (defined later)
            //disabling and hiding the combobox for this as well
            format_combo.setDisable(true);
            format_combo.setOpacity(0);

            //setting dynamic labels for stopwatch
            firstscr.setText("MilliSec");
            secondscr.setText("Seconds");
            thirdscr.setText("Minutes");

            //hiding timer buttons
            hrdown.setOpacity(0);hrup.setOpacity(0);mindown.setOpacity(0);minup.setOpacity(0);secdown.setOpacity(0);secup.setOpacity(0);
            //And showing Stopwatch buttons
            stopW1.setOpacity(1);stopW2.setOpacity(1);
            lap_pane.setOpacity(1);

            //disabling Timer Buttons
            hrdown.setDisable(true);hrup.setDisable(true);mindown.setDisable(true);minup.setDisable(true);secdown.setDisable(true);secup.setDisable(true);
            //And showing Stopwatch buttons
            stopW1.setDisable(false);stopW2.setDisable(false);

            //Hiding and disabling more Timer buttons
            timer_btn1.setOpacity(0);
            timer_btn2.setOpacity(0);
            timer_btn1.setDisable(true); timer_btn2.setDisable(true);

            //Setting switch variable to 1 for Stopwatch
            switchtype=1;
        }
        //When Timer is selected (MOST COMPLEX)
        else if(type_combo.getValue().equals("Timer")){
            counter=0;//Resetting counter for timer
            lap_box.getChildren().clear();//and clearing lap screen
            //Called 2 times for safety
            SevenSegmentDisplay(0,0,0);
            SevenSegmentDisplay(0,0,0);

            //Setting dynamic label for instructions for Timer
            timer_label.setFont(Font.font(null, FontWeight.BOLD,12));
            timer_label.setText("To set large values,Hover over the Timer and Scroll");
            timer_label.setLayoutX(180);
            timer_label.setTextFill(Color.RED);
            //And there is no use of format combobox in Timer
            format_combo.setDisable(true);
            format_combo.setOpacity(0);

            //Setting dynamic labels for Timer
            firstscr.setText("Seconds");
            secondscr.setText("Minutes");
            thirdscr.setText("Hours");

            //Showing Timer Buttons
            hrdown.setOpacity(1);hrup.setOpacity(1);mindown.setOpacity(1);minup.setOpacity(1);secdown.setOpacity(1);secup.setOpacity(1);
            //hiding Stopwatch Buttons
            stopW1.setOpacity(0);stopW2.setOpacity(0);
            lap_pane.setOpacity(0);

            //Enabling Timer Buttons
            hrdown.setDisable(false);hrup.setDisable(false);mindown.setDisable(false);minup.setDisable(false);secdown.setDisable(false);secup.setDisable(false);
            //But disabling stopwatch buttons
            stopW1.setDisable(true);stopW2.setDisable(true);

            //Showing Timer buttons but as disabled ,cause firstly user must set the Timer for the usage of these buttons
            timer_btn1.setOpacity(.5);
            timer_btn2.setOpacity(.5);
            timer_btn1.setDisable(true); timer_btn2.setDisable(true);

            //Setting switch variable to 2 for Timer
            switchtype=2;
            timerset();//initially calling the timer
        }
    }

    /**================================================ METHOD FOR CLOCK'S LOGIC ====================================================**/
    public void Clock() {
        //Creating new thread because clock req infinite loop and that loop must run parallel for the usage of other parts of the program
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {

                //Created a infinite loop
                while(true) {
                    //as long as the switch variable remains 0 this loop goes on
                    if(switchtype!=0){
                        //Any change to switch variable breaks the loop
                        //clearing the Screens for other modes
                        SevenSegmentDisplay(0,0,0);break;
                    }

                    try {
                        Thread.sleep(10);//delay of 10 milliseconds (it req exception handling)
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    //getting current hour
                    HH=java.time.LocalTime.now().getHour();;
                    //12hr Format
                    if (format_combo.getValue().equals("12 HR Format"))
                        if(HH==12)
                        HH=HH%13;//for showing 12 at noon as well
                    else
                            HH=HH%12;//normal conversion

                    //getting current minutes and seconds as well
                    MM = java.time.LocalTime.now().getMinute();
                    SS = java.time.LocalTime.now().getSecond() ;

                    //And Showing them on the Screens
                    SevenSegmentDisplay(HH,MM,SS);

                    //Blinking dots that blinks every 2 times/sec
                    if (java.time.LocalTime.now().getNano() / 100000000 % 5 == 0) {//conversion of nano seconds to 10 milliseconds
                        dot1.setOpacity(0);
                        dot2.setOpacity(0);
                        dot3.setOpacity(0);
                        dot4.setOpacity(0);
                    } else {
                        dot1.setOpacity(1);
                        dot2.setOpacity(1);
                        dot3.setOpacity(1);
                        dot4.setOpacity(1);
                    }

                }
            }
        });
        //Thread only starts wen switch variable permits
        if(switchtype==0)
        t.start();
        //joining thread when mode is switched
        if(switchtype!=0){
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    /**========================================== METHOD FOR STOPWATCH'S LOGIC ===================================================**/
    public void Stopwatch(){
//When Start button is pressed
        if(stopW1.isArmed() && stopW1.getText().equals("Start")){switchtype=1;//setting switch type to continue the stopwatch
                stopW1.setText("Pause");//changing Start button to Stop
        stopW2.setText("Lap");//changing reset button to lap

            //At first time all screens must show zeroes
        if(counter==0){
            HH=MM=SS=0;
            counter++;
        }

        //created new thread explained above
            Thread t=new Thread(new Runnable() {
                @Override
                public void run() {
                    while(switchtype==1) {//infinite loop until switch is changed


                        try {
                            Thread.sleep(10);//delay for 10 milliseconds
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        SS++;//incrementing milliseconds nut due to delay this infinite loop is under control
                        //when its reaches 100 then next second incremented
                        if(SS>=100) {
                            SS = 0;//resetting its value to 0
                            MM++;

                            //when seconds reaches to 60 one minute gets incremented
                            if (MM >= 60) {
                                MM = 0;//resetting its value to 0
                                HH++;

                                //when minutes reaches 60 resetting it to 0 ,cause there is no further screens to increment :))
                                if (HH >= 60)
                                    HH = 0;
                            }
                        }

                        //Final result displays at the SCREEN
                        SevenSegmentDisplay(HH,MM,SS);


                    }
                }
            });
        //thread is created when switch type permits
            if(switchtype==1)t.start();

            //joining thread when mode is switched
            if(switchtype!=1){
                try {
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        //When Stop is pressed
        else if(stopW1.isArmed() && stopW1.getText().equals("Pause")){
            //Stopwatch paused (infinite loop breaks)
        switchtype=4;
        //Setting again the fisrt button Start
        stopW1.setText("Start");
        //when stopwatch is paused user can reset its values
        stopW2.setText("Reset");
    }
        //When Reset is pressed
        if(stopW2.isArmed() && stopW2.getText().equals("Reset")){
            //resetting all the values to initial and displaying zeroes to screen
            counter=0;SevenSegmentDisplay(0,0,0);HH=MM=SS=0;
            //also clearing lap box
            lap_box.getChildren().clear();
        }

        //When Lap is pressed
        else if(stopW2.isArmed() && stopW2.getText().equals("Lap")){
            Label label=new Label();//created new label for storing current lap
            label.setText("           "+HH+" : "+MM+" : "+SS);//created new lap
            label.setFont(Font.font("System", 20));//some properties

            //finally adding it to lap screen at first index (ALL PREVIOUS VALUES SLIDES DOWN)
            lap_box.getChildren().add(0,label);

        }

    }

    /**======================================= METHOD FOR SETTING TIMER VALUES ===================================================**/
    public void timerset(){
        //initially setting all the values to zero when mode is switched to Timer
        if(counter<=1){
            HH=MM=SS=0;
            counter++;
        }
//---------------------------------------THIS METHOD IS LINKED WITH SCROLL-------------------------------------------------///

        //--------------------------------ALL THE SCREENS ARE SCROLL SENSITIVE-----------------------------------------------///
             if(switchtype==2){
            p1.setOnScroll(new EventHandler<ScrollEvent>() {
                @Override
                public void handle(ScrollEvent scrollEvent) {
                    //Setting lower and upper caps as scrolls up and down for 1st screen
                    if(scrollEvent.getDeltaY()>0 && HH>0) HH--;
                    else if(scrollEvent.getDeltaY()<0 && HH<99) HH++;
                }
            });
            //same functionality as above for 2nd screen
            p2.setOnScroll(new EventHandler<ScrollEvent>() {
                @Override
                public void handle(ScrollEvent scrollEvent) {
                    if(scrollEvent.getDeltaY()>0 && HH>0) HH--;
                    else if(scrollEvent.getDeltaY()<0 && HH<99) HH++;
                }
            });

            p3.setOnScroll(new EventHandler<ScrollEvent>() {
                @Override
                public void handle(ScrollEvent scrollEvent) {
                    //same functionality as above for 3rd screen
                    if(scrollEvent.getDeltaY()>0){
                         //when scroll reaches 0 then next value decremented by 1
                        if(MM<=0){
                            MM=59;HH--;
                        }else MM--;
                    }
                     else if(scrollEvent.getDeltaY()<0) {
                         //when scroll reaches 59 then next value incremented  by 1
                         if(MM>=59){
                             MM=0;HH++;
                         }else MM++;
                     }
                }
            });
            //same as above for 4th screen
            p4.setOnScroll(new EventHandler<ScrollEvent>() {
                @Override
                public void handle(ScrollEvent scrollEvent) {
                    if(scrollEvent.getDeltaY()>0){
                        if(MM<=0){
                            MM=59;HH--;
                        }else MM--;
                    }
                    else if(scrollEvent.getDeltaY()<0) {
                        if(MM>=59){
                            MM=0;HH++;
                        }else MM++;
                    }
                }
            });
            //same functionality as above for 5th screen
            p5.setOnScroll(new EventHandler<ScrollEvent>() {
                @Override
                public void handle(ScrollEvent scrollEvent) {
                      if(scrollEvent.getDeltaY()>0){
                          //Same increment and decrement but for minutes as well as for hours
                        if(SS<=0){
                            SS=59;
                            if(MM<=0){//when both seconds and minutes reaches 0 then 1 hr gets decremented
                                MM=59;HH--;
                            }else MM--;
                        }else SS--;
                    }
                      //same for increment
                      else if(scrollEvent.getDeltaY()<0){
                          if(SS>=59){
                              SS=0;
                              if(MM>=59){//when both seconds and minutes reaches 59 1 hr gets incremented
                                  MM=0;HH++;
                              }else MM++;
                          }else SS++;
                      }
                }
            });
            //same functionality for 6th screen SAME CODE BUT FOR 6TH SCREEN LISTENER
            p6.setOnScroll(new EventHandler<ScrollEvent>() {
                @Override
                public void handle(ScrollEvent scrollEvent) {
                    if(scrollEvent.getDeltaY()>0){
                        if(SS<=0){
                            SS=59;
                            if(MM<=0){//Blah blah blah
                                MM=59;HH--;
                            }else MM--;
                        }else SS--;
                    }
                    //some more blah blah
                    else if(scrollEvent.getDeltaY()<0){
                        if(SS>=59){
                            SS=0;
                            if(MM>=59){
                                MM=0;HH++;
                            }else MM++;

                        }else SS++;
                    }
                }
            });
        }
//-------------------------------------HERE STARTS THE BUTTONS LISTENER---------------------------------------------------------

        //when hr buttons are pressed values increases ir decreases with limits 0 to 99
        if((hrup.isArmed() && HH<99) )HH++;
        else if(hrdown.isArmed() && HH>0)HH--;

        //when minutes buttons are triggered
         if(minup.isArmed()) {
             // Cap limit of 59 ,then 1 hr incremented
            if(MM>=59){
                MM=0;HH++;
            }else MM++;
        }
       else if(mindown.isArmed()){
           //same for decrement
            if(MM<=0){
                MM=59;HH--;
            }else MM--;
        }

       //when Seconds buttons are triggered
       if(secup.isArmed()){
           //Cap limit of 59 then 1 min incremented
            if(SS>=59){
                SS=0;
                // Cap limit of 59 for minutes also ,then 1 hr incremented
                if(MM>=59){
                    MM=0;HH++;
                }else MM++;//otherwise peacefully increment 1 min

            }else SS++;//and more otherwise increases 1 sec
        }

       //Same functionality but for decrement
        else  if(secdown.isArmed()){
            if(SS<=0){
                SS=59;
                //same blah blah
                if(MM<=0){
                    MM=59;HH--;
                }else MM--;
            }else SS--;
        }

        //For preventing accidental scrolls while Timer is running
        if(switchtype==2) {
            //only displays when Timer is in Edit mode
            SevenSegmentDisplay(HH, MM, SS);

            //And also If all the values are 0 then Start button are useless
            //So disabling them
            if(!(HH==0 && MM==0 && SS==0)){
                timer_btn1.setDisable(false);
                timer_btn1.setOpacity(1);
                counter=2;//resetting Counter for Again assigning value to Seconds variable (explained later)
            }
            //when Timer has some values all buttons are enabled including Reset Button
            else {
                timer_btn1.setDisable(true);
                timer_btn1.setOpacity(.5);
                timer_btn2.setDisable(true);
                timer_btn2.setOpacity(.5);
            }
        }
    }

    /**============================================== METHOD FOR TIMER LOGIC =======================================================**/
    public void timerrun(){
        //At first time of timer start all values have reset
        if (counter == 2) {
            counter++;
            //initial variables for notification
            initHH=HH;
            initMM=MM;
            initSS=SS;
            //seconds variable is used but with microseconds so multiplied with 100ms
            SS*=100;

        }
        //when Timer is in Running mode switch state is changed so that Timer does not be edited
       switchtype=3;
        //setting reset button to stop
        timer_btn2.setText("Stop");
        //Also when Timer is running mode should not be switched to clock or stopwatch
        type_combo.setDisable(true);

        //disabled Start button and enabled Stop button
                timer_btn1.setDisable(true);
                timer_btn1.setOpacity(.5);
                timer_btn2.setDisable(false);
                timer_btn2.setOpacity(1);

                //Also disabled All the screens Sensitivity to Scroll (Extra safety otherwise switch variable can handle this)
                p1.setDisable(true);
                p2.setDisable(true);
                p3.setDisable(true);
                p4.setDisable(true);
                p5.setDisable(true);
                p6.setDisable(true);

                //disabled all the Timer buttons in running state
        hrdown.setOpacity(.5);hrup.setOpacity(.5);mindown.setOpacity(.5);minup.setOpacity(.5);secdown.setOpacity(.5);secup.setOpacity(.5);
        hrdown.setDisable(true);
        hrup.setDisable(true);
        mindown.setDisable(true);
        minup.setDisable(true);
        secdown.setDisable(true);
        secup.setDisable(true);



                //Created new thread for timer
                Thread t=new Thread(new Runnable() {
                    @Override
                    public void run() {

                        while(switchtype==3){//Infinite loop until switch state is changed

                            try {
                                Thread.sleep(10);//delay for controlling infinite loop's Iterations
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            //WHEN TIMER REACHES ZERO (FINISHED)
                            if(HH==0 && MM==0 && SS==0){
                                //switch combobox is enabled
                                type_combo.setDisable(false);

                                //Enabled all the Screens for Scroll sensitivity
                                p1.setDisable(false);
                                p2.setDisable(false);
                                p3.setDisable(false);
                                p4.setDisable(false);
                                p5.setDisable(false);
                                p6.setDisable(false);

                                //And enabled all the timer buttons for setting values
                                hrdown.setOpacity(1);hrup.setOpacity(1);mindown.setOpacity(1);minup.setOpacity(1);secdown.setOpacity(1);secup.setOpacity(1);
                                hrdown.setDisable(false);
                                hrup.setDisable(false);
                                mindown.setDisable(false);
                                minup.setDisable(false);
                                secdown.setDisable(false);
                                secup.setDisable(false);

                                //Start and Stop buttons should be enabled BUT it is disabled because Timer has zero values and it automatically gets enabled
                                //when Timer gets some values

                                timer_btn1.setDisable(true);
                                timer_btn1.setOpacity(.5);
                                timer_btn2.setDisable(true);
                                timer_btn2.setOpacity(.5);

                                //Setting Timer State to editable
                                switchtype=2;
                                try {
                                    notification();//calling notification when timer is finished
                                } catch (AWTException e) {
                                    e.printStackTrace();
                                }

                                //Finally Loop breaks when Timer gets Finished by this whole Block
                                break;
                            }

                            //here second variable is controlled by milliseconds (100) so 6000 means 1 min gets completed
                            if(SS<=0){
                                SS=6000;//when seconds becomes 0 , it resets to again 60
                                if(MM<=0){//and if minutes also gets zero then one hour gets decremented
                                    MM=60;HH--;
                                }
                                else // peacefully decreasing minutes
                                MM--;

                            }

                            //100 milliseconds decreasing per seconds
                            SS--;
                            // and finally printing result on the screen
                            SevenSegmentDisplay(HH,MM,SS/100);

                        }

                    }
                });
                //same logic as above
                if(switchtype==3)
                    t.start();
                //blah blah blah
                if(switchtype!=3){
                    try {
                        t.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

        }
    }

    /**==========================================METHOD FOR STOP AND RESET TIMER=================================================**/
    public void timerstop(){
        //when stop button is triggered
        if(timer_btn2.getText().equals("Stop")){
            //changing switch type to pause timer initially
            switchtype=4;
            //When timer stops start button gets enabled
            timer_btn1.setDisable(false);
            timer_btn1.setOpacity(1);
            //and stop button become reset
            timer_btn2.setText("Reset and Edit");
        }
        //When reset button is pressed
        else if(timer_btn2.getText().equals("Reset and Edit")){type_combo.setDisable(false);
        //it changes to stop button
            //BASICALLY WHOLE TIMER GETS RESET (SAME FUNCTIONALITY AS TIMER GETS FINISHED)
            timer_btn2.setText("Stop");
            //resetting all values and displaying zeroes to the screen
            HH=MM=SS=0;
            SevenSegmentDisplay(0,0,0);

            //enabling all the screens for scroll sensitivity
            p1.setDisable(false);
            p2.setDisable(false);
            p3.setDisable(false);
            p4.setDisable(false);
            p5.setDisable(false);
            p6.setDisable(false);

            //and enabling all the timer buttons to set TIMER again
            hrdown.setOpacity(1);hrup.setOpacity(1);mindown.setOpacity(1);minup.setOpacity(1);secdown.setOpacity(1);secup.setOpacity(1);
            hrdown.setDisable(false);
            hrup.setDisable(false);
            mindown.setDisable(false);
            minup.setDisable(false);
            secdown.setDisable(false);
            secup.setDisable(false);

            //Start and Stop buttons should be enabled BUT it is disabled because Timer has zero values and it automatically gets enabled
            //when Timer gets some values
            timer_btn1.setDisable(true);
            timer_btn1.setOpacity(.5);
            timer_btn2.setDisable(true);
            timer_btn2.setOpacity(.5);

            //and changing switch type so that TIMER gets in edit mode
            switchtype=2;
        }
    }

    /**===================================METHOD FOR NOTIFICATION WHEN ON TIMER FINISHED===================================**/
    public void notification() throws AWTException {
        SystemTray tray = SystemTray.getSystemTray();

        //If the icon is a file
        Image image = Toolkit.getDefaultToolkit().createImage("icon.png");
        //Alternative (if the icon is on the classpath):
        //Image image = Toolkit.getDefaultToolkit().createImage(getClass().getResource("icon.png"));

        TrayIcon trayIcon = new TrayIcon(image, "Tray Demo");
        //Let the system resize the image if needed
        trayIcon.setImageAutoSize(true);
        //Set tooltip text for the tray icon
        trayIcon.setToolTip("System tray icon demo");
        tray.add(trayIcon);
        //displaying custom msg notification with initial TIMER values
        trayIcon.displayMessage("Timer Finished", initHH+" : "+initMM+" : "+initSS,TrayIcon.MessageType.INFO);
    }

    /**===================================METHOD FOR CONTROLLING ALL THE SEVEN SEGMENTS=====================================**/
    public void SevenSegmentDisplay(int Screen1,int Screen2,int Screen3){
        //EACH VALUE IS CUT INTO TWO PIECES FOR TWO SCREENS AS THE VALUE IS TWO DIGIT

        /**HERE THE LOGIC OF EACH SEGMENT FOR DISPLAYING DIFF NUMBERS ON ALL THE SCREENS IS ENABLING ONE SCREEN**/
        /**AT A TIME AND DISABLING ALL OTHER FIVE**/

        //Enabling only 1st screen and disabling others by boolean (explained later)
        switch (Screen1/10) {//getting hour value and extracting ten's term for 1st screen
            case 0 -> digital0(true, false, false, false, false, false);
            case 1 -> digital1(true, false, false, false, false, false);
            case 2 -> digital2(true, false, false, false, false, false);
            case 3 -> digital3(true, false, false, false, false, false);
            case 4 -> digital4(true, false, false, false, false, false);
            case 5 -> digital5(true, false, false, false, false, false);
            case 6 -> digital6(true, false, false, false, false, false);
            case 7 -> digital7(true, false, false, false, false, false);
            case 8 -> digital8(true, false, false, false, false, false);
            case 9 -> digital9(true, false, false, false, false, false);
            default -> SevenSegmentDisplay(0,0,0);
        }

        //Enabling only 2nd screen and disabling others by boolean (explained later)
        switch (Screen1%10) {//getting hour value and extracting one's term for 2nd screen
            case 0 -> digital0(false, true, false, false, false, false);
            case 1 -> digital1(false, true, false, false, false, false);
            case 2 -> digital2(false, true, false, false, false, false);
            case 3 -> digital3(false, true, false, false, false, false);
            case 4 -> digital4(false, true, false, false, false, false);
            case 5 -> digital5(false, true, false, false, false, false);
            case 6 -> digital6(false, true, false, false, false, false);
            case 7 -> digital7(false, true, false, false, false, false);
            case 8 -> digital8(false, true, false, false, false, false);
            case 9 -> digital9(false, true, false, false, false, false);
            default -> SevenSegmentDisplay(0,0,0);
        }

        //Enabling only 3rd screen and disabling others by boolean (explained later)
        switch (Screen2/10) {//getting minute value and extracting ten's term for 3rd screen
            case 0 -> digital0(false, false, true, false, false, false);
            case 1 -> digital1(false, false, true, false, false, false);
            case 2 -> digital2(false, false, true, false, false, false);
            case 3 -> digital3(false, false, true, false, false, false);
            case 4 -> digital4(false, false, true, false, false, false);
            case 5 -> digital5(false, false, true, false, false, false);
            case 6 -> digital6(false, false, true, false, false, false);
            case 7 -> digital7(false, false, true, false, false, false);
            case 8 -> digital8(false, false, true, false, false, false);
            case 9 -> digital9(false, false, true, false, false, false);
            default -> SevenSegmentDisplay(0,0,0);
        }

        //Enabling only 4th screen and disabling others by boolean (explained later)
        switch (Screen2%10) {//getting minute value and extracting one's term for 4th screen
            case 0 -> digital0(false, false, false, true, false, false);
            case 1 -> digital1(false, false, false, true, false, false);
            case 2 -> digital2(false, false, false, true, false, false);
            case 3 -> digital3(false, false, false, true, false, false);
            case 4 -> digital4(false, false, false, true, false, false);
            case 5 -> digital5(false, false, false, true, false, false);
            case 6 -> digital6(false, false, false, true, false, false);
            case 7 -> digital7(false, false, false, true, false, false);
            case 8 -> digital8(false, false, false, true, false, false);
            case 9 -> digital9(false, false, false, true, false, false);
            default -> SevenSegmentDisplay(0,0,0);
        }

        //Enabling only 5th screen and disabling others by boolean (explained later)
        switch (Screen3/10) {//getting hour second and extracting ten's term for 5th screen
            case 0 -> digital0(false, false, false, false, true, false);
            case 1 -> digital1(false, false, false, false, true, false);
            case 2 -> digital2(false, false, false, false, true, false);
            case 3 -> digital3(false, false, false, false, true, false);
            case 4 -> digital4(false, false, false, false, true, false);
            case 5 -> digital5(false, false, false, false, true, false);
            case 6 -> digital6(false, false, false, false, true, false);
            case 7 -> digital7(false, false, false, false, true, false);
            case 8 -> digital8(false, false, false, false, true, false);
            case 9 -> digital9(false, false, false, false, true, false);
            default -> SevenSegmentDisplay(0,0,0);
        }

        //Enabling only 6th screen and disabling others by boolean (explained later)
        switch (Screen3%10) {//getting second value and extracting one's term for 6th screen
            case 0 -> digital0(false, false, false, false, false, true);
            case 1 -> digital1(false, false, false, false, false, true);
            case 2 -> digital2(false, false, false, false, false, true);
            case 3 -> digital3(false, false, false, false, false, true);
            case 4 -> digital4(false, false, false, false, false, true);
            case 5 -> digital5(false, false, false, false, false, true);
            case 6 -> digital6(false, false, false, false, false, true);
            case 7 -> digital7(false, false, false, false, false, true);
            case 8 -> digital8(false, false, false, false, false, true);
            case 9 -> digital9(false, false, false, false, false, true);
            default -> SevenSegmentDisplay(0,0,0);
        }
    }

    /**================================== METHOD FOR CONSTRUCTING 0 ON SEVEN SEGMENT ========================================**/
    public void digital0(boolean pane1,boolean pane2,boolean pane3,boolean pane4,boolean pane5,boolean pane6){
        //All the Seven segments are from "a to g" controlled by opacity
        //and displays enabled one at a time ,this is controlled by boolean arguments set by caller
       if(pane1) {p1a.setOpacity(1); p1b.setOpacity(1); p1c.setOpacity(1); p1d.setOpacity(1); p1e.setOpacity(1); p1f.setOpacity(1); p1g.setOpacity(.1);}
       if(pane2) {p2a.setOpacity(1); p2b.setOpacity(1); p2c.setOpacity(1); p2d.setOpacity(1); p2e.setOpacity(1); p2f.setOpacity(1); p2g.setOpacity(.1);}
       if(pane3) {p3a.setOpacity(1); p3b.setOpacity(1); p3c.setOpacity(1); p3d.setOpacity(1); p3e.setOpacity(1); p3f.setOpacity(1); p3g.setOpacity(.1);}
       if(pane4) {p4a.setOpacity(1); p4b.setOpacity(1); p4c.setOpacity(1); p4d.setOpacity(1); p4e.setOpacity(1); p4f.setOpacity(1); p4g.setOpacity(.1);}
       if(pane5) {p5a.setOpacity(1); p5b.setOpacity(1); p5c.setOpacity(1); p5d.setOpacity(1); p5e.setOpacity(1); p5f.setOpacity(1); p5g.setOpacity(.1);}
       if(pane6) {p6a.setOpacity(1); p6b.setOpacity(1); p6c.setOpacity(1); p6d.setOpacity(1); p6e.setOpacity(1); p6f.setOpacity(1); p6g.setOpacity(.1);}
    }

    /**================================== METHOD FOR CONSTRUCTING 1 ON SEVEN SEGMENT ========================================**/
    public void digital1(boolean pane1,boolean pane2,boolean pane3,boolean pane4,boolean pane5,boolean pane6){
        //All the Seven segments are from "a to g" controlled by opacity
        //and displays enabled one at a time ,this is controlled by boolean arguments set by caller
        if(pane1) {p1a.setOpacity(.1); p1b.setOpacity(1); p1c.setOpacity(1); p1d.setOpacity(.1); p1e.setOpacity(.1); p1f.setOpacity(.1); p1g.setOpacity(.1);}
        if(pane2) {p2a.setOpacity(.1); p2b.setOpacity(1); p2c.setOpacity(1); p2d.setOpacity(.1); p2e.setOpacity(.1); p2f.setOpacity(.1); p2g.setOpacity(.1);}
        if(pane3) {p3a.setOpacity(.1); p3b.setOpacity(1); p3c.setOpacity(1); p3d.setOpacity(.1); p3e.setOpacity(.1); p3f.setOpacity(.1); p3g.setOpacity(.1);}
        if(pane4) { p4a.setOpacity(.1); p4b.setOpacity(1); p4c.setOpacity(1); p4d.setOpacity(.1); p4e.setOpacity(.1); p4f.setOpacity(.1); p4g.setOpacity(.1);}
        if(pane5) { p5a.setOpacity(.1); p5b.setOpacity(1); p5c.setOpacity(1); p5d.setOpacity(.1); p5e.setOpacity(.1); p5f.setOpacity(.1); p5g.setOpacity(.1);}
        if(pane6) {p6a.setOpacity(.1); p6b.setOpacity(1); p6c.setOpacity(1); p6d.setOpacity(.1); p6e.setOpacity(.1); p6f.setOpacity(.1); p6g.setOpacity(.1);}
    }

    /**================================== METHOD FOR CONSTRUCTING 2 ON SEVEN SEGMENT ========================================**/
    public void digital2(boolean pane1,boolean pane2,boolean pane3,boolean pane4,boolean pane5,boolean pane6){
        //All the Seven segments are from "a to g" controlled by opacity
        //and displays enabled one at a time ,this is controlled by boolean arguments set by caller
       if(pane1) { p1a.setOpacity(1); p1b.setOpacity(1); p1c.setOpacity(.1); p1d.setOpacity(1); p1e.setOpacity(1); p1f.setOpacity(.1); p1g.setOpacity(1);}
       if(pane2) { p2a.setOpacity(1); p2b.setOpacity(1); p2c.setOpacity(.1); p2d.setOpacity(1); p2e.setOpacity(1); p2f.setOpacity(.1); p2g.setOpacity(1);}
       if(pane3) { p3a.setOpacity(1); p3b.setOpacity(1); p3c.setOpacity(.1); p3d.setOpacity(1); p3e.setOpacity(1); p3f.setOpacity(.1); p3g.setOpacity(1);}
       if(pane4) { p4a.setOpacity(1); p4b.setOpacity(1); p4c.setOpacity(.1); p4d.setOpacity(1); p4e.setOpacity(1); p4f.setOpacity(.1); p4g.setOpacity(1);}
       if(pane5) { p5a.setOpacity(1); p5b.setOpacity(1); p5c.setOpacity(.1); p5d.setOpacity(1); p5e.setOpacity(1); p5f.setOpacity(.1); p5g.setOpacity(1);}
       if(pane6) { p6a.setOpacity(1); p6b.setOpacity(1); p6c.setOpacity(.1); p6d.setOpacity(1); p6e.setOpacity(1); p6f.setOpacity(.1); p6g.setOpacity(1);}
    }

    /**================================== METHOD FOR CONSTRUCTING 3 ON SEVEN SEGMENT ========================================**/
    public void digital3(boolean pane1,boolean pane2,boolean pane3,boolean pane4,boolean pane5,boolean pane6){
        //All the Seven segments are from "a to g" controlled by opacity
        //and displays enabled one at a time ,this is controlled by boolean arguments set by caller
       if(pane1) { p1a.setOpacity(1); p1b.setOpacity(1); p1c.setOpacity(1); p1d.setOpacity(1); p1e.setOpacity(.1); p1f.setOpacity(.1); p1g.setOpacity(1);}
       if(pane2) { p2a.setOpacity(1); p2b.setOpacity(1); p2c.setOpacity(1); p2d.setOpacity(1); p2e.setOpacity(.1); p2f.setOpacity(.1); p2g.setOpacity(1);}
       if(pane3) { p3a.setOpacity(1); p3b.setOpacity(1); p3c.setOpacity(1); p3d.setOpacity(1); p3e.setOpacity(.1); p3f.setOpacity(.1); p3g.setOpacity(1);}
       if(pane4) { p4a.setOpacity(1); p4b.setOpacity(1); p4c.setOpacity(1); p4d.setOpacity(1); p4e.setOpacity(.1); p4f.setOpacity(.1); p4g.setOpacity(1);}
       if(pane5) { p5a.setOpacity(1); p5b.setOpacity(1); p5c.setOpacity(1); p5d.setOpacity(1); p5e.setOpacity(.1); p5f.setOpacity(.1); p5g.setOpacity(1);}
       if(pane6) { p6a.setOpacity(1); p6b.setOpacity(1); p6c.setOpacity(1); p6d.setOpacity(1); p6e.setOpacity(.1); p6f.setOpacity(.1); p6g.setOpacity(1);}
    }

    /**================================== METHOD FOR CONSTRUCTING 4 ON SEVEN SEGMENT ========================================**/
    public void digital4(boolean pane1,boolean pane2,boolean pane3,boolean pane4,boolean pane5,boolean pane6){
        //All the Seven segments are from "a to g" controlled by opacity
        //and displays enabled one at a time ,this is controlled by boolean arguments set by caller
     if(pane1) {  p1a.setOpacity(.1); p1b.setOpacity(1); p1c.setOpacity(1); p1d.setOpacity(.1); p1e.setOpacity(.1); p1f.setOpacity(1); p1g.setOpacity(1);}
     if(pane2) {  p2a.setOpacity(.1); p2b.setOpacity(1); p2c.setOpacity(1); p2d.setOpacity(.1); p2e.setOpacity(.1); p2f.setOpacity(1); p2g.setOpacity(1);}
     if(pane3) {  p3a.setOpacity(.1); p3b.setOpacity(1); p3c.setOpacity(1); p3d.setOpacity(.1); p3e.setOpacity(.1); p3f.setOpacity(1); p3g.setOpacity(1);}
     if(pane4) {  p4a.setOpacity(.1); p4b.setOpacity(1); p4c.setOpacity(1); p4d.setOpacity(.1); p4e.setOpacity(.1); p4f.setOpacity(1); p4g.setOpacity(1);}
     if(pane5) {  p5a.setOpacity(.1); p5b.setOpacity(1); p5c.setOpacity(1); p5d.setOpacity(.1); p5e.setOpacity(.1); p5f.setOpacity(1); p5g.setOpacity(1);}
     if(pane6) {  p6a.setOpacity(.1); p6b.setOpacity(1); p6c.setOpacity(1); p6d.setOpacity(.1); p6e.setOpacity(.1); p6f.setOpacity(1); p6g.setOpacity(1);}
    }

    /**================================== METHOD FOR CONSTRUCTING 5 ON SEVEN SEGMENT ========================================**/
    public void digital5(boolean pane1,boolean pane2,boolean pane3,boolean pane4,boolean pane5,boolean pane6){
        //All the Seven segments are from "a to g" controlled by opacity
        //and displays enabled one at a time ,this is controlled by boolean arguments set by caller
       if(pane1) { p1a.setOpacity(1); p1b.setOpacity(.1); p1c.setOpacity(1); p1d.setOpacity(1); p1e.setOpacity(.1); p1f.setOpacity(1); p1g.setOpacity(1);}
       if(pane2) { p2a.setOpacity(1); p2b.setOpacity(.1); p2c.setOpacity(1); p2d.setOpacity(1); p2e.setOpacity(.1); p2f.setOpacity(1); p2g.setOpacity(1);}
       if(pane3) { p3a.setOpacity(1); p3b.setOpacity(.1); p3c.setOpacity(1); p3d.setOpacity(1); p3e.setOpacity(.1); p3f.setOpacity(1); p3g.setOpacity(1);}
       if(pane4) { p4a.setOpacity(1); p4b.setOpacity(.1); p4c.setOpacity(1); p4d.setOpacity(1); p4e.setOpacity(.1); p4f.setOpacity(1); p4g.setOpacity(1);}
       if(pane5) { p5a.setOpacity(1); p5b.setOpacity(.1); p5c.setOpacity(1); p5d.setOpacity(1); p5e.setOpacity(.1); p5f.setOpacity(1); p5g.setOpacity(1);}
       if(pane6) { p6a.setOpacity(1); p6b.setOpacity(.1); p6c.setOpacity(1); p6d.setOpacity(1); p6e.setOpacity(.1); p6f.setOpacity(1); p6g.setOpacity(1);}
    }

    /**================================== METHOD FOR CONSTRUCTING 6 ON SEVEN SEGMENT ========================================**/
    public void digital6(boolean pane1,boolean pane2,boolean pane3,boolean pane4,boolean pane5,boolean pane6){
        //All the Seven segments are from "a to g" controlled by opacity
        //and displays enabled one at a time ,this is controlled by boolean arguments set by caller
      if(pane1) { p1a.setOpacity(1); p1b.setOpacity(.1); p1c.setOpacity(1); p1d.setOpacity(1); p1e.setOpacity(1); p1f.setOpacity(1); p1g.setOpacity(1);}
      if(pane2) { p2a.setOpacity(1); p2b.setOpacity(.1); p2c.setOpacity(1); p2d.setOpacity(1); p2e.setOpacity(1); p2f.setOpacity(1); p2g.setOpacity(1);}
      if(pane3) { p3a.setOpacity(1); p3b.setOpacity(.1); p3c.setOpacity(1); p3d.setOpacity(1); p3e.setOpacity(1); p3f.setOpacity(1); p3g.setOpacity(1);}
      if(pane4) { p4a.setOpacity(1); p4b.setOpacity(.1); p4c.setOpacity(1); p4d.setOpacity(1); p4e.setOpacity(1); p4f.setOpacity(1); p4g.setOpacity(1);}
      if(pane5) { p5a.setOpacity(1); p5b.setOpacity(.1); p5c.setOpacity(1); p5d.setOpacity(1); p5e.setOpacity(1); p5f.setOpacity(1); p5g.setOpacity(1);}
      if(pane6) { p6a.setOpacity(1); p6b.setOpacity(.1); p6c.setOpacity(1); p6d.setOpacity(1); p6e.setOpacity(1); p6f.setOpacity(1); p6g.setOpacity(1);}
    }

    /**================================== METHOD FOR CONSTRUCTING 7 ON SEVEN SEGMENT ========================================**/
    public void digital7(boolean pane1,boolean pane2,boolean pane3,boolean pane4,boolean pane5,boolean pane6){
        //All the Seven segments are from "a to g" controlled by opacity
        //and displays enabled one at a time ,this is controlled by boolean arguments set by caller
      if(pane1) {  p1a.setOpacity(1); p1b.setOpacity(1); p1c.setOpacity(1); p1d.setOpacity(.1); p1e.setOpacity(.1); p1f.setOpacity(.1); p1g.setOpacity(.1);}
      if(pane2) {  p2a.setOpacity(1); p2b.setOpacity(1); p2c.setOpacity(1); p2d.setOpacity(.1); p2e.setOpacity(.1); p2f.setOpacity(.1); p2g.setOpacity(.1);}
      if(pane3) {  p3a.setOpacity(1); p3b.setOpacity(1); p3c.setOpacity(1); p3d.setOpacity(.1); p3e.setOpacity(.1); p3f.setOpacity(.1); p3g.setOpacity(.1);}
      if(pane4) {  p4a.setOpacity(1); p4b.setOpacity(1); p4c.setOpacity(1); p4d.setOpacity(.1); p4e.setOpacity(.1); p4f.setOpacity(.1); p4g.setOpacity(.1);}
      if(pane5) {  p5a.setOpacity(1); p5b.setOpacity(1); p5c.setOpacity(1); p5d.setOpacity(.1); p5e.setOpacity(.1); p5f.setOpacity(.1); p5g.setOpacity(.1);}
      if(pane6) {  p6a.setOpacity(1); p6b.setOpacity(1); p6c.setOpacity(1); p6d.setOpacity(.1); p6e.setOpacity(.1); p6f.setOpacity(.1); p6g.setOpacity(.1);}
    }

    /**================================== METHOD FOR CONSTRUCTING 8 ON SEVEN SEGMENT ========================================**/
    public void digital8(boolean pane1,boolean pane2,boolean pane3,boolean pane4,boolean pane5,boolean pane6){
        //All the Seven segments are from "a to g" controlled by opacity
        //and displays enabled one at a time ,this is controlled by boolean arguments set by caller
       if(pane1) {     p1a.setOpacity(1); p1b.setOpacity(1); p1c.setOpacity(1); p1d.setOpacity(1); p1e.setOpacity(1); p1f.setOpacity(1); p1g.setOpacity(1);}
       if(pane2) {     p2a.setOpacity(1); p2b.setOpacity(1); p2c.setOpacity(1); p2d.setOpacity(1); p2e.setOpacity(1); p2f.setOpacity(1); p2g.setOpacity(1);}
       if(pane3) {     p3a.setOpacity(1); p3b.setOpacity(1); p3c.setOpacity(1); p3d.setOpacity(1); p3e.setOpacity(1); p3f.setOpacity(1); p3g.setOpacity(1);}
       if(pane4) {     p4a.setOpacity(1); p4b.setOpacity(1); p4c.setOpacity(1); p4d.setOpacity(1); p4e.setOpacity(1); p4f.setOpacity(1); p4g.setOpacity(1);}
       if(pane5) {     p5a.setOpacity(1); p5b.setOpacity(1); p5c.setOpacity(1); p5d.setOpacity(1); p5e.setOpacity(1); p5f.setOpacity(1); p5g.setOpacity(1);}
       if(pane6) {     p6a.setOpacity(1); p6b.setOpacity(1); p6c.setOpacity(1); p6d.setOpacity(1); p6e.setOpacity(1); p6f.setOpacity(1); p6g.setOpacity(1);}
    }

    /**================================== METHOD FOR CONSTRUCTING 9 ON SEVEN SEGMENT ========================================**/
    public void digital9(boolean pane1,boolean pane2,boolean pane3,boolean pane4,boolean pane5,boolean pane6){
        //All the Seven segments are from "a to g" controlled by opacity
        //and displays enabled one at a time ,this is controlled by boolean arguments set by caller
    if(pane1) {    p1a.setOpacity(1); p1b.setOpacity(1); p1c.setOpacity(1); p1d.setOpacity(1); p1e.setOpacity(.1); p1f.setOpacity(1); p1g.setOpacity(1);}
    if(pane2) {    p2a.setOpacity(1); p2b.setOpacity(1); p2c.setOpacity(1); p2d.setOpacity(1); p2e.setOpacity(.1); p2f.setOpacity(1); p2g.setOpacity(1);}
    if(pane3) {    p3a.setOpacity(1); p3b.setOpacity(1); p3c.setOpacity(1); p3d.setOpacity(1); p3e.setOpacity(.1); p3f.setOpacity(1); p3g.setOpacity(1);}
    if(pane4) {    p4a.setOpacity(1); p4b.setOpacity(1); p4c.setOpacity(1); p4d.setOpacity(1); p4e.setOpacity(.1); p4f.setOpacity(1); p4g.setOpacity(1);}
    if(pane5) {    p5a.setOpacity(1); p5b.setOpacity(1); p5c.setOpacity(1); p5d.setOpacity(1); p5e.setOpacity(.1); p5f.setOpacity(1); p5g.setOpacity(1);}
    if(pane6) {    p6a.setOpacity(1); p6b.setOpacity(1); p6c.setOpacity(1); p6d.setOpacity(1); p6e.setOpacity(.1); p6f.setOpacity(1); p6g.setOpacity(1);}
    }

    /**================================== METHOD CALLED AT THE EXECUTION OF THE PROGRAM======================================**/
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        //firstly screen should be cleared
            SevenSegmentDisplay(0,0,0);

            //initial color
            color.setValue(Color.DARKCYAN);
            setcolor();

            //Filling mode switching combobox
            type_combo.getItems().addAll("Clock","Stopwatch","Timer");
            type_combo.setValue("Clock");

            //Filling Format  combobox
            format_combo.getItems().addAll("12 HR Format","24 HR Format") ;
            format_combo.setValue("12 HR Format");

            //HIDING AND DISABLING ALL THE BUTTONS BECAUSE AT INITIALLY CLOCK GETS CALLED
            hrdown.setOpacity(0);hrup.setOpacity(0);mindown.setOpacity(0);minup.setOpacity(0);secdown.setOpacity(0);secup.setOpacity(0);
            stopW1.setOpacity(0);stopW2.setOpacity(0);

        hrdown.setDisable(true);hrup.setDisable(true);mindown.setDisable(true);minup.setDisable(true);secdown.setDisable(true);secup.setDisable(true);
        stopW1.setDisable(true);stopW2.setDisable(true);

        timer_btn1.setOpacity(0);
        timer_btn2.setOpacity(0);
        timer_btn1.setDisable(true); timer_btn2.setDisable(true);

        //calling mode switching function (AT FIRST CLOCK GETS CALLED CAUSE SWITCH VARIABLE IS '0')
            setType_combo();

    }
}
