package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import javax.swing.*;
import javax.swing.text.AbstractDocument;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Driver;
import java.util.ArrayList;
public class App extends JFrame {
    private static ChromeDriver chromeDriver;
    private static boolean isConnected=false;
    private static String phoneNumberInput;
    private   static String contentInput;
    public static ArrayList<Component> components=new ArrayList<>();
    private static int count=10;
    private static int hold=1;


    public App(){
        this.setSize(400,600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setFocusable(true);
        this.setLayout(null);
        this.setTitle("whatsApp utility mod");

        System.setProperty("webdriver.openqa.driver", "path/to/chromedriver.exe");

        ImageIcon whatsAppLogo=new ImageIcon("resources/whatsAppLogo.png");
        this.setIconImage(whatsAppLogo.getImage());

        ImageIcon whatsAppBackground=new ImageIcon("resources/whatsAppBackground.jpg");
        Image image=whatsAppBackground.getImage().getScaledInstance(this.getWidth(),this.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(image);
        JLabel background = new JLabel(scaledIcon);
        background.setBounds(0,0,this.getWidth(),this.getHeight());
        this.setContentPane(background);

        JButton enterWhatsApp=new JButton("ENTER");
        enterWhatsApp.setBounds(150,400,100,30);
        this.add(enterWhatsApp);

        JButton guide=new JButton("GUIDE");
        guide.setBounds(150,350,100,30);
        this.add(guide);

        JButton returnButton1=new JButton("GO BACK");
        returnButton1.setBounds(200,500,100,30);
        returnButton1.setVisible(false);
        this.add(returnButton1);

        JButton returnButton2=new JButton("GO BACK");
        returnButton2.setBounds(200,500,100,30);
        returnButton2.setVisible(false);
        this.add(returnButton2);

        JButton returnButton3=new JButton("GO BACK");
        returnButton3.setBounds(200,500,100,30);
        returnButton3.setVisible(false);
        this.add(returnButton3);

        JButton continueButton1=new JButton("Continue");
        continueButton1.setBounds(100,500,100,30);
        continueButton1.setVisible(false);
        this.add(continueButton1);

        JButton continueButton2=new JButton("Continue");
        continueButton2.setBounds(100,500,100,30);
        continueButton2.setVisible(false);
        this.add(continueButton2);

        JButton continueButton3=new JButton("Got it");
        continueButton3.setBounds(100,500,100,30);
        continueButton3.setVisible(false);
        this.add(continueButton3);

        JButton sendMessage=new JButton("Send");
        sendMessage.setBounds(150,400,100,30);
        sendMessage.setVisible(false);
        this.add(sendMessage);

        JLabel connected=new JLabel("Connected");
        connected.setBounds(20,20,130,30);
        connected.setBackground(Color.WHITE.brighter());
        connected.setForeground(Color.BLACK.darker());
        connected.setFont(new Font("Ariel",Font.PLAIN,26));
        connected.setBorder(BorderFactory.createLineBorder(Color.darkGray,2));
        connected.setVisible(false);
        connected.setOpaque(true);
        this.add(connected);

        JLabel messageSent=new JLabel("message sent successfully");
        messageSent.setBounds(50,50,300,30);
        messageSent.setVisible(false);
        this.add(messageSent);

        JLabel status1Label=new JLabel("current status: V");
        status1Label.setBounds(50,90,300,30);
        status1Label.setVisible(false);
        this.add(status1Label);

        JLabel status2Label=new JLabel("current status: VV");
        status2Label.setBounds(50,70,300,30);
        status2Label.setVisible(false);
        this.add(status2Label);

        JLabel status3Label=new JLabel("current status: Blue V");
        status3Label.setBounds(50,90,300,30);
        status3Label.setVisible(false);
        this.add(status3Label);

        JLabel addressLabel=new JLabel("phone number: ");
        addressLabel.setBounds(50,200,100,30);
        addressLabel.setForeground(Color.BLACK.darker());
        addressLabel.setVisible(false);
        this.add(addressLabel);

        JTextField addressField=new JTextField();
        ((AbstractDocument) addressField.getDocument()).setDocumentFilter(new NumericFilter());
        addressField.setBounds(addressLabel.getWidth()+addressLabel.getX(),200,100,30);
        addressField.setEditable(true);
        addressField.setVisible(false);
        this.add(addressField);
        addressField.setColumns(12);

        JLabel contentLabel=new JLabel("description: ");
        contentLabel.setBounds(addressLabel.getX(),addressField.getHeight()+addressField.getY()+20,100,30);
        contentLabel.setForeground(Color.BLACK.darker());
        contentLabel.setVisible(false);
        this.add(contentLabel);

        JTextField contentField=new JTextField();
        contentField.setBounds(contentLabel.getX()+addressLabel.getWidth(),contentLabel.getY(),200,100);
        contentField.setEditable(true);
        contentField.setVisible(false);
        this.add(contentField);

        JLabel instructionsText1=new JLabel("click on the column of dots on the left side");
        instructionsText1.setBounds(80,150,300,30);
        instructionsText1.setVisible(false);
        this.add(instructionsText1);
        JLabel instructions1=new JLabel();
        instructions1.setBounds(50,200,300,100);
        ImageIcon instructionsIcon1=new ImageIcon("resources/instructions1.jpg");
        Image constructionsImage1=instructionsIcon1.getImage();
        Image scaledConstructionsImage1=constructionsImage1.getScaledInstance(instructions1.getWidth(),instructions1.getHeight(),constructionsImage1.SCALE_SMOOTH);
        ImageIcon scaledConstructionsIcon1=new ImageIcon(scaledConstructionsImage1);
        instructions1.setIcon(scaledConstructionsIcon1);
        instructions1.setVisible(false);
        this.add(instructions1);


        JLabel instructions2=new JLabel();
        instructions2.setBounds(100,200,200,200);
        ImageIcon instructionsIcon2=new ImageIcon("resources/instructions2.jpg");
        Image constructionsImage2=instructionsIcon2.getImage();
        Image scaledConstructionsImage2=constructionsImage2.getScaledInstance(instructions2.getWidth(),instructions2.getHeight(),constructionsImage2.SCALE_SMOOTH);
        ImageIcon scaledConstructionsIcon2=new ImageIcon(scaledConstructionsImage2);
        instructions2.setIcon(scaledConstructionsIcon2);
        instructions2.setVisible(false);
        this.add(instructions2);

        JLabel instructions3=new JLabel();
        instructions3.setBounds(50,250,300,200);
        ImageIcon instructionsIcon3=new ImageIcon("resources/instructions3.jpg");
        Image constructionsImage3=instructionsIcon3.getImage();
        Image scaledConstructionsImage3=constructionsImage3.getScaledInstance(instructions3.getWidth(),instructions3.getHeight(),constructionsImage3.SCALE_SMOOTH);
        ImageIcon scaledConstructionsIcon3=new ImageIcon(scaledConstructionsImage3);
        instructions3.setIcon(scaledConstructionsIcon3);
        instructions3.setVisible(false);
        this.add(instructions3);

        components.add(sendMessage);
        components.add(connected);
        components.add(addressField);
        components.add(addressLabel);
        components.add(contentField);
        components.add(contentLabel);

        JLabel errorComment1=new JLabel("*it appears this phone number is incorrect");
        errorComment1.setBounds(50,60,300,30);
        errorComment1.setVisible(false);
        this.add(errorComment1);

        JLabel errorComment2=new JLabel("*you haven't entered a phone number");
        errorComment2.setBounds(50,60,300,30);
        errorComment2.setVisible(false);
        this.add(errorComment2);

        JLabel errorComment3=new JLabel("*you haven't entered any content");
        errorComment3.setBounds(50,90,300,30);
        errorComment3.setVisible(false);
        this.add(errorComment3);

        JLabel errorComment4=new JLabel("it appears you're disconnected");
        errorComment4.setBounds(50,60,300,30);
        errorComment4.setVisible(false);
        this.add(errorComment4);

        JLabel errorComment5=new JLabel("your ip address is unreachable");
        errorComment5.setBounds(50,90,300,30);
        errorComment5.setVisible(false);
        this.add(errorComment5);

        enterWhatsApp.addActionListener(e -> {
            errorComment4.setVisible(!Utility.isInternetConnected());          //
            errorComment5.setVisible(!Utility.checkForResponse());             //
            if(errorComment4.isVisible() || errorComment5.isVisible()){return;}//

            chromeDriver=new ChromeDriver();
            chromeDriver.get("https://web.whatsapp.com/");
            String currentUrl=chromeDriver.getCurrentUrl();
            String barcodeId="//*[@id=\"app\"]/div/div/div[3]/div[1]/div/div/div[2]/div";


            while (!isConnected){
                try {
                    WebElement element = chromeDriver.findElement(By.xpath(barcodeId));
                    isConnected = false;
                } catch (NoSuchElementException es) {
                    if(currentUrl.equals(chromeDriver.getCurrentUrl())){
                        enterWhatsApp.setVisible(false);
                        guide.setVisible(false);
                        setConnected(connected);
                        isConnected = true;
                    }
                }
                try {Thread.sleep(1000);} catch (InterruptedException es) {es.printStackTrace();}
            }
        });

        guide.addActionListener(e -> {
            guide.setVisible(false);
            enterWhatsApp.setVisible(false);
            continueButton1.setVisible(true);
            returnButton1.setVisible(true);
            instructionsText1.setVisible(true);
            instructions1.setVisible(true);
        });

        continueButton1.addActionListener(e -> {
            instructionsText1.setVisible(false);
            instructions1.setVisible(false);
            returnButton1.setVisible(false);
            continueButton1.setVisible(false);
            returnButton2.setVisible(true);
            continueButton2.setVisible(true);
            instructions2.setVisible(true);
        });

        returnButton1.addActionListener(e -> {
            guide.setVisible(true);
            instructionsText1.setVisible(false);
            enterWhatsApp.setVisible(true);
            instructions1.setVisible(false);
            returnButton1.setVisible(false);
            continueButton1.setVisible(false);
        });

        returnButton2.addActionListener(e -> {
            instructions1.setVisible(true);
            returnButton1.setVisible(true);
            continueButton1.setVisible(true);
            instructions2.setVisible(false);
            returnButton2.setVisible(false);
            continueButton2.setVisible(false);
        });

        continueButton2.addActionListener(e -> {
            instructions3.setVisible(true);
            continueButton3.setVisible(true);
            returnButton3.setVisible(true);
            returnButton2.setVisible(false);
            continueButton2.setVisible(false);
            instructions2.setVisible(false);
        });

        returnButton3.addActionListener(e -> {
            continueButton3.setVisible(false);
            returnButton3.setVisible(false);
            instructions3.setVisible(false);
            instructions2.setVisible(true);
            returnButton2.setVisible(true);
            continueButton2.setVisible(true);
        });

        continueButton3.addActionListener(e -> {
            returnButton3.setVisible(false);
            continueButton3.setVisible(false);
            instructions3.setVisible(false);
            guide.setVisible(true);
            enterWhatsApp.setVisible(true);
        });


        addressField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    sendMessage.doClick();
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        contentField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    sendMessage.doClick();
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        sendMessage.addActionListener(e -> {
            count=10;
            status3Label.setVisible(false);
            status2Label.setVisible(false);
            status1Label.setVisible(false);



            boolean proceed=true;
            if(addressField.getText().isEmpty() || contentField.getText().isEmpty() || !isValidPhoneNumber(addressField.getText())){
                errorComment2.setVisible(addressField.getText().isEmpty());
                errorComment3.setVisible(contentField.getText().isEmpty());
                if(!errorComment2.isVisible()){errorComment1.setVisible(!isValidPhoneNumber(addressField.getText()));}
                proceed=false;
            }
            if (proceed){
                errorComment1.setVisible(false); errorComment2.setVisible(false); errorComment3.setVisible(false);
                phoneNumberInput=setPhoneNumberFormat(addressField.getText());
                contentInput=contentField.getText();

                WebElement searchBar = chromeDriver.findElement(By.xpath("/html/body/div[1]/div/div/div[4]/div/div[1]/div/div/div[2]/div/div[1]/p"));
                if(searchBar.getText().isEmpty()){
                    searchBar.sendKeys(phoneNumberInput);

                    if (!searchBar.getText().equals(phoneNumberInput)) {
                        WebElement clearSearchBar = chromeDriver.findElement(By.xpath("/html/body/div[1]/div/div/div[4]/div/div[1]/div/div/span/button/span"));
                        clearSearchBar.click();
                    }
                    try {Thread.sleep(1000);} catch (InterruptedException ex) {throw new RuntimeException(ex);}
                    searchBar.sendKeys(Keys.ENTER);
                }

                WebElement textBar=chromeDriver.findElement(By.xpath("/html/body/div[1]/div/div/div[5]/div/footer/div[1]/div/span[2]/div/div[2]/div[1]/div/div[1]/p"));
                try {Thread.sleep(1000);}catch (InterruptedException ex){throw new RuntimeException(ex);}


                getPosition();
                count-=2;
                String path = "/html/body/div[1]/div/div/div[5]/div/div[2]/div/div[2]/div[3]/div[" + count + "]/div/div/div/div[1]/div[1]/div[2]/div/div/span";

                textBar.sendKeys(contentInput);
                try {Thread.sleep(500);} catch (InterruptedException ex) {throw new RuntimeException(ex);}
                textBar.sendKeys(Keys.ENTER);
                displayForAPeriod(messageSent);

                try {Thread.sleep(1000);} catch (InterruptedException ex) {throw new RuntimeException(ex);}

                System.out.println(getPosition());
                WebElement currentStatus=chromeDriver.findElement(By.xpath(path));
                if(currentStatus.getAttribute("aria-label").contains("נשלחה")){
                    displayForAPeriod(status3Label);
                }

            }

        });

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            if (chromeDriver != null) {
                chromeDriver.quit();
                this.removeAll();
                enterWhatsApp.setVisible(true);
                guide.setVisible(true);
            }
        }));
        setVisible(true);
    }
    private static void setConnected(Component text){
        for(Component component:components){
            component.setVisible(true);
        }
        displayForAPeriod(text);
    }
    private static boolean isValidPhoneNumber(String phoneNumber){return phoneNumber.matches("^05[0-9]{8}$") || phoneNumber.matches("^9725[0-9]{8}$");}
    private static String setPhoneNumberFormat(String phoneNumber){
        String format="";
        if(phoneNumber.matches("^9725[0-9]{8}$")){format=phoneNumber;} else {format="972"+phoneNumber.substring(1);}
        return format;
    }
    private static void displayForAPeriod(Component text){
        text.setVisible(true);
        Thread displayed = new Thread(() -> {
            try {
                Thread.sleep(13000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            SwingUtilities.invokeLater(() -> text.setVisible(false));
        });
        displayed.start();
    }

    private static String getPosition() {
        String path = "/html/body/div[1]/div/div/div[5]/div/div[2]/div/div[2]/div[3]/div[" + count + "]/div/div/div/div[1]/div[1]/div[2]/div/div/span";
        int counter=0;
        while (true) {
            try {
                WebElement webElement = chromeDriver.findElement(By.xpath(path));
                if (webElement == null) {
                    counter++;
                    if(counter==100){
                        break;
                    }
                }
                path = "/html/body/div[1]/div/div/div[5]/div/div[2]/div/div[2]/div[3]/div[" + count + "]/div/div/div/div[1]/div[1]/div[2]/div/div/span";
            } catch (NoSuchElementException e) {
                break;
            }
            count++;
        }

        return path;
    }


}