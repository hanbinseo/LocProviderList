package android.studio.practice.locproviderlist;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class LocProviderListActivity extends AppCompatActivity {
    TextView mTextView;
    Button mButton;
    LocationManager locMgr;
    List<String> locProviders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.txtOutput);
        mButton = findViewById(R.id.button);

        mButton.setOnClickListener(new View.OnClickListener() {ad
            @Override
            public void onClick(View v) {
                locMgr = (LocationManager) getSystemService(LOCATION_SERVICE); // new location Manager() ?

                locProviders = locMgr.getAllProviders();

                String s = "";
                for (int i = 0; i < locProviders.size(); i++) {
                    s += "Loc. Provider " + locProviders.get(i) + "\n"
                            + "Status : " + locMgr.isProviderEnabled(locProviders.get(i)) + "\n\n";
                }

                mTextView.setText(s);
            }
        });
    }

}