package ut.itic92.sunshineitic92;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            final ArrayList<Clima> listaClima = new ArrayList<Clima>();
            listaClima.add(new Clima("Lunes", "Soleado","33°/28°", R.drawable.soleado));
            listaClima.add(new Clima("Martes", "Nublado","33°/28°", R.drawable.nublado));
            listaClima.add(new Clima("Miercoles", "Tormenta","33°/28°", R.drawable.tormenta));
            listaClima.add(new Clima("Jueves", "lluvioso","33°/28°", R.drawable.lluvia));
            listaClima.add(new Clima("Viernes", "Nublado","33°/28°", R.drawable.nublado));
            listaClima.add(new Clima("Sabado","Tormenta","31°/27",R.drawable.tormenta));
            listaClima.add(new Clima("Domingo","Lluvioso","30°/25",R.drawable.lluvia));

            List<Clima> lista = (List) listaClima;

            ClimaAdapter climaAdapter = new ClimaAdapter(getActivity(), R.layout.list_item_forecast, lista);

            ListView listView = (ListView) rootView.findViewById(R.id.list_item_forecast);
            listView.setAdapter(climaAdapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent intent;
                    switch (position) {

                        case 0: {
                            intent = new Intent(getActivity(), LunesMain.class);
                            startActivity(intent);
                            break;
                        }
                        case 1: {
                            intent = new Intent(getActivity(), MartesMain.class);
                            startActivity(intent);
                            break;
                        }
                        case 2: {
                            intent = new Intent(getActivity(), MiercolesMain.class);
                            startActivity(intent);
                            break;
                        }
                        case 3: {
                            intent = new Intent(getActivity(), JuevesMain.class);
                            startActivity(intent);
                            break;
                        }
                        case 4: {
                            intent = new Intent(getActivity(), ViernesMain.class);
                            startActivity(intent);
                            break;
                        }
                        case 5: {
                            intent = new Intent(getActivity(), SabadoMain.class);
                            startActivity(intent);
                            break;
                        }
                        case 6: {
                            intent = new Intent(getActivity(), DomingoMain.class);
                            startActivity(intent);
                            break;
                        }
                    }
                }
            });

            return rootView;
        }
    }
}
