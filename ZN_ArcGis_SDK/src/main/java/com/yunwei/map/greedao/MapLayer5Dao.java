package com.yunwei.map.greedao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * DAO for table "MAP_LAYER5".
*/
public class MapLayer5Dao extends AbstractDao<MapLayer5, Void> {

    public static final String TABLENAME = "MAP_LAYER5";

    /**
     * Properties of entity MapLayer5.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property LayerType = new Property(0, Integer.class, "layerType", false, "LAYER_TYPE");
        public final static Property Level = new Property(1, Integer.class, "level", false, "LEVEL");
        public final static Property Col = new Property(2, Integer.class, "col", false, "COL");
        public final static Property Row = new Property(3, Integer.class, "row", false, "ROW");
        public final static Property Layer = new Property(4, byte[].class, "layer", false, "LAYER");
    };


    public MapLayer5Dao(DaoConfig config) {
        super(config);
    }
    
    public MapLayer5Dao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"MAP_LAYER5\" (" + //
                "\"LAYER_TYPE\" INTEGER," + // 0: layerType
                "\"LEVEL\" INTEGER," + // 1: level
                "\"COL\" INTEGER," + // 2: col
                "\"ROW\" INTEGER," + // 3: row
                "\"LAYER\" BLOB);"); // 4: layer
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"MAP_LAYER5\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, MapLayer5 entity) {
        stmt.clearBindings();
 
        Integer layerType = entity.getLayerType();
        if (layerType != null) {
            stmt.bindLong(1, layerType);
        }
 
        Integer level = entity.getLevel();
        if (level != null) {
            stmt.bindLong(2, level);
        }
 
        Integer col = entity.getCol();
        if (col != null) {
            stmt.bindLong(3, col);
        }
 
        Integer row = entity.getRow();
        if (row != null) {
            stmt.bindLong(4, row);
        }
 
        byte[] layer = entity.getLayer();
        if (layer != null) {
            stmt.bindBlob(5, layer);
        }
    }

    /** @inheritdoc */
    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    /** @inheritdoc */
    @Override
    public MapLayer5 readEntity(Cursor cursor, int offset) {
        MapLayer5 entity = new MapLayer5( //
            cursor.isNull(offset + 0) ? null : cursor.getInt(offset + 0), // layerType
            cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1), // level
            cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2), // col
            cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3), // row
            cursor.isNull(offset + 4) ? null : cursor.getBlob(offset + 4) // layer
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, MapLayer5 entity, int offset) {
        entity.setLayerType(cursor.isNull(offset + 0) ? null : cursor.getInt(offset + 0));
        entity.setLevel(cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1));
        entity.setCol(cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2));
        entity.setRow(cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3));
        entity.setLayer(cursor.isNull(offset + 4) ? null : cursor.getBlob(offset + 4));
     }
    
    /** @inheritdoc */
    @Override
    protected Void updateKeyAfterInsert(MapLayer5 entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    /** @inheritdoc */
    @Override
    public Void getKey(MapLayer5 entity) {
        return null;
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
