package com.josuecamelo.com.gestorcliente;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Client> clients = Client.findAll();

        RecyclerView recyclerView = findViewById(R.id.recClients);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        ClientsAdapter adapter = new ClientsAdapter(clients);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(),DividerItemDecoration.VERTICAL));

        Button addBtn = findViewById(R.id.addClientBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Criando um link
                Intent addClientIntent = new Intent(getApplicationContext(), AddClientActivity.class);
                // Link criando --> vรก para a activity
                startActivity(addClientIntent);
            }
        });
    }
}
