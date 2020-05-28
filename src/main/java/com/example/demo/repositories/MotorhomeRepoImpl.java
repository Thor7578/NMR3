package com.example.demo.repositories;

import com.example.demo.models.Motorhome;
import com.example.demo.util.DatabaseConnectionManager;

import java.sql.Connection;

public class MotorhomeRepoImpl implements IMotorhomeRepo {
    private Connection conn;

    public MotorhomeRepoImpl(){this.conn = DatabaseConnectionManager.getDatabaseConnection();
    }

    @Override
    public int Create(Motorhome motorhome) {
        int newMotorhomeID = 0;
        return newMotorhomeID;
    }

    @Override
    public int Read(Motorhome motorhome) {
        return 0;
    }
}
