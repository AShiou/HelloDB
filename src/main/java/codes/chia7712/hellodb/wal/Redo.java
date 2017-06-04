package codes.chia7712.hellodb.wal;

import codes.chia7712.hellodb.CommandEnum;
import codes.chia7712.hellodb.admin.Admin;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author hsinying
 */
public class Redo {

  RandomAccessFile file;

  void start(Admin admin) throws IOException {
    long lsn;
    int cmd = 0;
    byte[] tableName, row, col, val;
    while (file.getFilePointer() >= file.length()) {
      lsn = file.readLong();
      tableName = new byte[file.readInt()];
      file.read(tableName);
      cmd = file.readInt();
      row = new byte[file.readInt()];
      file.read(row);
      col = new byte[file.readInt()];
      file.read(col);
      val = new byte[file.readInt()];
      file.read(val);
      /**
       * put task to queue
       */
      switch (CommandEnum.getEnum(cmd)) {
        case CREATE_TABLE:
          break;
        case DELETE_TABLE:
          break;
        case INSERT_CELL:
          break;
        case INSERT_CELL_IF_ANSENT:
          break;
        case DELETE_CELL:
          break;
        case DELETE_CELLS_BY_ROW:
          break;
        default:
          throw new IOException();

      }
    }
  }

  public Redo() throws FileNotFoundException {
    file = new RandomAccessFile("wal", "rw");
  }
}
