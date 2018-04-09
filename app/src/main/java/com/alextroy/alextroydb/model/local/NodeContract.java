package com.alextroy.alextroydb.model.local;

import android.provider.BaseColumns;

public class NodeContract {

    private NodeContract() {
    }

    public static final class NodeEntry implements BaseColumns {

        public static final String TABLE_NAME = "nodes";

        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_NODE_VALUE = "value";
    }
}
