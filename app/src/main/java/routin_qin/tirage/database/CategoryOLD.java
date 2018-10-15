package routin_qin.tirage.database;

import android.database.Cursor;
import android.provider.BaseColumns;

public class CategoryOLD implements BaseColumns {
    public static String TABLE_NAME = "category";
    public static int COLUMN_NUM_ID = 0;
    public static String COLUMN_NAME_TITLE = "title";
    public static int COLUMN_NUM_TITLE = 1;
    public static String COLUMN_NAME_DESCRIPTION = "description";
    public static int COLUMN_NUM_DESCRIPTION = 2;
    private int id;
    private String title;
    private String description;

    public CategoryOLD(Cursor cursor){
        this.id = cursor.getInt(COLUMN_NUM_ID);
        this.title = cursor.getString(COLUMN_NUM_TITLE);
        this.title = cursor.getString(COLUMN_NUM_DESCRIPTION);
    }


}
