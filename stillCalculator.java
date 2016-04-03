//u10416021 張馨容
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.Group;

public class stillCalculator extends Application {
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
  	//set title
    primaryStage.setTitle("stillCalculator"); 
	//set GridPane
	GridPane gridpane = new GridPane();
	// set GridPane to align center 
	gridpane.setAlignment(Pos.TOP_CENTER);
	gridpane.setHgap(5);
	gridpane.setVgap(5);
	//create a Vbox (vertical)
	VBox vbox = new VBox();
	//create a group
	Group root = new Group();
	//create a scene
	Scene scene = new Scene(root, 230, 401);
	//create a textfield
	TextField tf = new TextField();
	//create an array to store the number that user clicked
    double[] temporary = {0, 0};
    //create a boolean array
    boolean[] function = new boolean[4];
    //use for loop to initialized each function to false
    for(int i = 0; i < 4; i++){
    	function[0]=false;
    }
	//create a menubar
	MenuBar menuBar = new MenuBar();
	menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
    Menu menuV = new Menu("檢視(V)");
    MenuItem A = new MenuItem("A");
    MenuItem B = new MenuItem("B");
    MenuItem C = new MenuItem("C");
	menuV.getItems().addAll(A, B, C);
	
    Menu menuE = new Menu("編輯(E)");
    MenuItem D = new MenuItem("D");
    MenuItem E = new MenuItem("E");
    MenuItem F = new MenuItem("F");
    menuE.getItems().addAll(D, E, F);
    
    Menu menuH = new Menu("說明(H)");
    MenuItem G = new MenuItem("G");
    MenuItem H = new MenuItem("H");
    MenuItem I = new MenuItem("I");
 	menuH.getItems().addAll(G, H, I);
    //add menuV.menuE.menuH to a menubar
    menuBar.getMenus().addAll(menuV,menuE,menuH);
    //add textfield to the gridpane
    gridpane.add(tf, 1,6,5,5);
    //set the size and editable to the textfield
    tf.setMinSize(225,60);
    tf.setEditable(false);
    //create a pane
    Pane pane = new Pane();
    //create bottons
    Button btMC = new Button("MC");
    btMC.setMinSize(40, 40);
    gridpane.add(btMC,1,12);
    btMC.setOnAction(e -> { 	});
    Button btMR = new Button("MR");
    btMR.setMinSize(40, 40);
    gridpane.add(btMR,2,12);
    btMR.setOnAction(e -> {	});
    Button btMS = new Button("MS");
    btMS.setMinSize(40, 40);
    gridpane.add(btMS,3,12);
    btMS.setOnAction(e -> {	});
    Button btMpl = new Button("M+");
    btMpl.setMinSize(40, 40);
    gridpane.add(btMpl,4,12);
    btMpl.setOnAction(e -> {	});
	Button btMmi = new Button("M-");
	btMmi.setMinSize(40, 40);
    gridpane.add(btMmi,5,12);
    btMmi.setOnAction(e -> {	});
    //delete
	Button btarr = new Button("←");
	btarr.setMinSize(40, 40);
    gridpane.add(btarr,1,14);
    //lambda expression
    btarr.setOnAction(e -> {
    	//get the text
    	String result = tf.getText();
    	//delete the last number
    	result = result.substring(0, result.length() - 1);
    	//set the result
    	tf.setText(result);
    });
    //delete the current string
	Button btCE = new Button("CE");
	btCE.setMinSize(40, 40);
    gridpane.add(btCE,2,14);
    btCE.setOnAction(e -> {
    	tf.setText("");
    });
    //delete all 
	Button btC = new Button("C");
	btC.setMinSize(40, 40);
    gridpane.add(btC,3,14);
    btC.setOnAction(e -> {
    	tf.clear();
    	tf.setText("");
    });
    //change it to positive or negative
	Button btpos = new Button("+/-");
	btpos.setMinSize(40, 40);
    gridpane.add(btpos,4,14);
    btpos.setOnAction(e -> {
    	double result = Double.parseDouble(tf.getText());
    	result = result * (-1);
    	tf.setText(Double.toString(result));
    });
    //use math class to sqrt the number
	Button btroo = new Button("√");
	btroo.setMinSize(40, 40);
    gridpane.add(btroo,5,14);
    btroo.setOnAction(e -> {
    	double result = Math.sqrt(Double.parseDouble(tf.getText())); 
    	tf.setText(Double.toString(result));
    });
    //show the number
	Button btsev = new Button("7");
	btsev.setMinSize(40, 40);
    gridpane.add(btsev,1,16);
    btsev.setOnAction(e -> {
    	int num =7;
        tf.setText(tf.getText() + num);
    });
    //show the number
	Button bteig = new Button("8");
	bteig.setMinSize(40, 40);
    gridpane.add(bteig,2,16);
    bteig.setOnAction(e -> {
    	int num =8;
        tf.setText(tf.getText() + num);
    });
    //show the number
	Button btnin = new Button("9");
	btnin.setMinSize(40, 40);
    gridpane.add(btnin,3,16);
    btnin.setOnAction(e -> {
    	int num =9;
        tf.setText(tf.getText() + num);
    });
    //divide the number
	Button btdiv = new Button("/");
	btdiv.setMinSize(40, 40);
    gridpane.add(btdiv,4,16);
    btdiv.setOnAction(e -> {
    	temporary[0] = Double.parseDouble(tf.getText());
    	tf.setText("");
    	function[3]=true;
    });
    //get the percentage of the number 
	Button btpa = new Button("%");
	btpa.setMinSize(40, 40);
    gridpane.add(btpa,5,16);
    btpa.setOnAction(e -> {
    	double result = Double.parseDouble(tf.getText()); 
    	result = result / 100;
    	tf.setText(Double.toString(result));
    });
    //show the number
	Button btfou = new Button("4");
	btfou.setMinSize(40, 40);
    gridpane.add(btfou,1,18);
    btfou.setOnAction(e -> {
    	int num =4;
        tf.setText(tf.getText() + num);
    });
    //show the number
	Button btfiv = new Button("5");
	btfiv.setMinSize(40, 40);
    gridpane.add(btfiv,2,18);
    btfiv.setOnAction(e -> {
    	int num =5;
        tf.setText(tf.getText() + num);
    });
    //show the number
	Button btsix = new Button("6");
	btsix.setMinSize(40, 40);
    gridpane.add(btsix,3,18);
    btsix.setOnAction(e -> {
    	int num =6;
        tf.setText(tf.getText() + num);
    });
    //multiple the number
	Button btmul = new Button("*");
	btmul.setMinSize(40, 40);
    gridpane.add(btmul,4,18);
    btmul.setOnAction(e -> {
    	temporary[0] = Double.parseDouble(tf.getText());
    	tf.setText("");
    	function[2]=true;
    });
    //get the reciprical of the number
	Button btdix = new Button("1/x");
	btdix.setMinSize(40, 40);
    gridpane.add(btdix,5,18);
    btdix.setOnAction(e -> {
    	double result = Double.parseDouble(tf.getText()); 
    	result = 1/result;
    	tf.setText(Double.toString(result));
    });
    //add the number
    Button btplu = new Button("+");
	btplu.setMinSize(40, 40);
    gridpane.add(btplu,4,21);
    btplu.setOnAction(e -> {
    	temporary[0] = Double.parseDouble(tf.getText());
    	tf.setText("");
    	function[0]=true;
    });
    //show the number
	Button btone = new Button("1");
	btone.setMinSize(40, 40);
    gridpane.add(btone,1,20);
    btone.setOnAction(e -> {
    	int num =1;
        tf.setText(tf.getText() + num);
    });
    //show the number
	Button bttwo = new Button("2");
	bttwo.setMinSize(40, 40);
    gridpane.add(bttwo,2,20);
    bttwo.setOnAction(e -> {
    	int num =2;
        tf.setText(tf.getText() + num);
    });
    //show the number
	Button btthr = new Button("3");
	btthr.setMinSize(40, 40);
    gridpane.add(btthr,3,20);
	btthr.setOnAction(e -> {
		int num =3;
        tf.setText(tf.getText() + num);
    });
    //divide the number
	Button btmin = new Button("-");
	btmin.setMinSize(40, 40);
    gridpane.add(btmin,4,20);
    btmin.setOnAction(e -> {
    	temporary[0] = Double.parseDouble(tf.getText());
    	tf.setText("");
    	function[1]=true;
    });
    //show the number
	Button btzer = new Button("0");
	btzer.setMinSize(82,40);
    gridpane.add(btzer,1,21,2,1);
    btzer.setOnAction(e -> {
    	int num =0;
        tf.setText(tf.getText() + num);	
    });
    //add the point to the number
	Button btpoi = new Button(".");
	btpoi.setMinSize(40, 40);
    gridpane.add(btpoi,3,21);
    btpoi.setOnAction(e -> {String num =".";
        tf.setText(tf.getText() + num);});
    //get the answer of the number
	Button btequ = new Button("=");
	btequ.setMinSize(40, 82);
    gridpane.add(btequ,5,20,1,2);
    btequ.setOnAction(e -> {
    	//get the second number from the textfield
    	temporary[1] = Double.parseDouble(tf.getText());
    	//add
    	if(function[0]==true){
    		double result = temporary[0] + temporary[1];
    		tf.setText(Double.toString(result));
    	}
    	//subtract
    	if(function[1]==true){
    		double result = temporary[0] - temporary[1];
    		tf.setText(Double.toString(result));
    	}
    	//multiple
    	if(function[2]==true){
    		double result = temporary[0] * temporary[1];
    		tf.setText(Double.toString(result));
    	}
    	//divide
    	if(function[3]==true){
    		double result = temporary[0] / temporary[1];
    		tf.setText(Double.toString(result));
    	}
    });

	//create a HBox
	HBox hBox = new HBox();
	//set spacing and alignment of the HBox
    hBox.setSpacing(10);
    hBox.setAlignment(Pos.CENTER);
    //add gridpane an d menubar to the group
    root.getChildren().add(gridpane);
    root.getChildren().add(menuBar);
    //set scene to the stage
    primaryStage.setScene(scene);
    //display the stage
    primaryStage.show(); 

  }
 
}