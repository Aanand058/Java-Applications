module Workshop_45 {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	
	opens application to javafx.graphics, javafx.fxml;
	opens controller to javafx.graphics,javafx.fxml;
	 opens model to javafx.base;
	
}
