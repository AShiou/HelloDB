package codes.chia7712.hellodb.wal;

import codes.chia7712.hellodb.CommandEnum;
import codes.chia7712.hellodb.data.Cell;
import java.io.IOException;

/**
 *
 * @author hsinying
 */
public interface WAL {

  /**
   * write to wal and return lsn
   *
   * @param tableName
   * @param cmd
   * @param cell
   * @return lsn
   * @throws java.io.IOException
   */
  long append(String tableName, CommandEnum cmd, Cell cell) throws IOException;

  /**
   * flush wal buffer to disk
   *
   * @throws java.io.IOException
   */
  void sync() throws IOException;

  public static WAL getSimpleWAL(int capacity) throws IOException {
    return new SimpleWAL("wal", capacity);
  }
}
