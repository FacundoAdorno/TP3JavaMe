package example;
import javax.microedition.lcdui.TextBox;
import javax.microedition.lcdui.Display;
import javax.microedition.location.*;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;


public class ExampleLocationMIDlet extends MIDlet implements LocationListener{

	private TextBox locationDescriptor;
	private LocationProvider locationProvider; 
	
	
	public TextBox getLocationDescriptor() {
		return locationDescriptor;
	}

	public void setLocationDescriptor(TextBox locationDescriptor) {
		this.locationDescriptor = locationDescriptor;
	}

	public LocationProvider getLocationProvider() {
		return locationProvider;
	}

	public void setLocationProvider(LocationProvider locationProvider) {
		this.locationProvider = locationProvider;
	}

	public ExampleLocationMIDlet() throws LocationException{
		setLocationProvider(LocationProvider.getInstance(new Criteria()));
		getLocationProvider().setLocationListener(this, 1, -1, -1);
	}
	
	public void locationUpdated(LocationProvider locationProvider, Location location){
		if(!(location == null)){
			QualifiedCoordinates coordinates = location.getQualifiedCoordinates();
			String textCoordinate = "Latitud: " + coordinates.getLatitude() + " Longitud: " + coordinates.getLongitude();
			setLocationDescriptor(new TextBox("Location",textCoordinate, 400, 0));
			Display.getDisplay(this).setCurrent(getLocationDescriptor());
		}
	}
	
	public void providerStateChanged(LocationProvider arg0, int arg1){
		
	}

	protected void destroyApp(boolean arg0) throws MIDletStateChangeException {
		// TODO Auto-generated method stub

	}

	protected void pauseApp() {
		// TODO Auto-generated method stub

	}

	protected void startApp() throws MIDletStateChangeException {
		// TODO Auto-generated method stub

	}

}

