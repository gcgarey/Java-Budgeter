/*
 * Student Name: Gabrielle Garey
 * Date: August 7, 2024
 * This Program is a basic budgeter that includes sections to calculate expenses, and designate commerce
 */
package application;
	
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;



public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("ExpandedBudget.fxml"));
			loader.setController(this);
			Parent root = loader.load();
			Scene scene = new Scene(root,400,400);
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML Button btnVisualize;
	@FXML Button btnPlan;
	@FXML Button btnTotal;
	@FXML TextField txtIncome;
	@FXML TextField txtEducation;
	@FXML TextField txtHousing;
	@FXML TextField txtFood;
	@FXML TextField txtTransportation;
	@FXML Label lblResult;
	
    
	public void initialize(){
		//lambda function to calculate total cost of bills. Will take in sections that the user inputs 
		//amounts for education, housing, food, and transportation and will outup 
		//to the lbl Result label
		btnTotal.setOnAction((event) -> {
            try {
                String educationInput = txtEducation.getText();
                double educationAmount = Double.parseDouble(educationInput);

                String housingInput = txtHousing.getText();
                double housingAmount = Double.parseDouble(housingInput);

                String foodInput = txtFood.getText();
                double foodAmount = Double.parseDouble(foodInput);

                String transportInput = txtTransportation.getText();
                double transportAmount = Double.parseDouble(transportInput);

                double totalAmount = educationAmount + housingAmount + foodAmount + transportAmount;

                lblResult.setText("Total expenses: $" + totalAmount);
            } catch (NumberFormatException e) {
                lblResult.setText("Please enter valid input");
            }
        });

		
		//Lambda function to calculate the percentages of the total budget that take up education,
		//housing, food, and transportation. Takes each of these fields and outputs percentages to 
		//the lblResults label
		btnVisualize.setOnAction((event) -> {
            try {
                String educationInput = txtEducation.getText();
                double educationAmount = Double.parseDouble(educationInput);

                String housingInput = txtHousing.getText();
                double housingAmount = Double.parseDouble(housingInput);

                String foodInput = txtFood.getText();
                double foodAmount = Double.parseDouble(foodInput);

                String transportInput = txtTransportation.getText();
                double transportAmount = Double.parseDouble(transportInput);

                double totalAmount = educationAmount + housingAmount + foodAmount + transportAmount;

                double educationPercent = educationAmount * 100 / totalAmount;
                double housingPercent = housingAmount * 100 / totalAmount;
                double foodPercent = foodAmount * 100 / totalAmount;
                double transportPercent = transportAmount * 100 / totalAmount;

                lblResult.setText(String.format(
                    "Education: %.2f%%\n\nHousing: %.2f%%\n\nFood: %.2f%%\n\nTransportation: %.2f%%",
                    educationPercent, housingPercent, foodPercent, transportPercent));
            } catch (NumberFormatException e) {
                lblResult.setText("Please enter valid input");
            }
        });
			
		//Lambda function to calculate the amount each person should be spending on needs, wants, and savings 
		//Takes in the field of total income and outputs to the lblResults label. 
		btnPlan.setOnAction((event) -> {
            try {
                String incomeInput = txtIncome.getText();
                double incomeAmount = Double.parseDouble(incomeInput);

                double needs = incomeAmount * 0.5;
                double wants = incomeAmount * 0.3;
                double savings = incomeAmount * 0.2;

                lblResult.setText("Needs: $" + needs + "\n\nWants: $" + wants +
                        "\n\nSavings: $" + savings);
            } catch (NumberFormatException e) {
                lblResult.setText("Please enter valid input");
            }
        });
		
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
