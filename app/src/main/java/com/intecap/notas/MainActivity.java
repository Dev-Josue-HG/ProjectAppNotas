package com.intecap.notas;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);





        BottomNavigationView navView = findViewById(R.id.bnvMenuNavegacionInferior);

        AppBarConfiguration abcBarraConfiguracion = new AppBarConfiguration.Builder(
                R.id.pagina_inicio, R.id.pagina_agregar, R.id.pagina_detalles
        ).build();

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fvcContenedorFragmentos);

        NavController nvcControladorNavegacion = navHostFragment.getNavController();

        nvcControladorNavegacion.setGraph(R.navigation.nav);

        NavigationUI.setupWithNavController(navView,nvcControladorNavegacion);

        navView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if(item.getItemId() == R.id.itmInicio){
                    nvcControladorNavegacion.navigate(R.id.pagina_inicio);
                } else if (item.getItemId() == R.id.itmAgregarNotas){
                    nvcControladorNavegacion.navigate(R.id.pagina_agregar);
                } else if (item.getItemId() == R.id.itmDetallesNotas){
                    nvcControladorNavegacion.navigate(R.id.pagina_detalles);
                }

                return true;
            }
        });

        navView.setOnItemReselectedListener(new NavigationBarView.OnItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.itmInicio){
                    Toast.makeText(MainActivity.this, "Inicio", Toast.LENGTH_SHORT).show();
                } else if (item.getItemId() == R.id.itmAgregarNotas){
                    Toast.makeText(MainActivity.this, "Agregar", Toast.LENGTH_SHORT).show();
                } else if (item.getItemId() == R.id.itmDetallesNotas) {
                    Toast.makeText(MainActivity.this, "Detalles", Toast.LENGTH_SHORT).show();
                }
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;


        });





    }

}