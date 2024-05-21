module W2 {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.base;
	
	opens application to javafx.graphics, javafx.fxml;
	opens controller to javafx.graphics,javafx.fxml;
}
