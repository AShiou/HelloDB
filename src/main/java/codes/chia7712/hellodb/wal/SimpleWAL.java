package codes.chia7712.hellodb.wal;

import codes.chia7712.hellodb.CommandEnum;
import codes.chia7712.hellodb.data.Cell;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

/**
 *
 * @author hsinying
 */
public class SimpleWAL implements WAL {

  private final ByteBuffer buffer;
  private final RandomAccessFile raf;
  private long lsn;

  SimpleWAL(String name, int bufferSize) throws IOException {
    buffer = ByteBuffer.allocate(bufferSize);
    raf = new RandomAccessFile(name, "rw");
    lsn = 0;
  }

  @Override
  public synchronized long append(String tableName, CommandEnum cmd, Cell cell) throws IOException {
    buffer.putLong(lsn);
    buffer.putInt(tableName.getBytes().length);
    buffer.put(tableName.getBytes());
    buffer.putInt(cmd.getInt());
    buffer.putInt(cell.getRowLength()).put(cell.getRowArray(), cell.getRowOffset(), cell.getRowLength());
    buffer.putInt(cell.getColumnLength()).put(cell.getColumnArray(), cell.getColumnOffset(), cell.getColumnLength());
    buffer.putInt(cell.getValueLength()).put(cell.getValueArray(), cell.getValueOffset(), cell.getValueLength());
    raf.write(buffer.array(), 0, buffer.position());
    buffer.clear();
    return lsn++;
  }

  @Override
  public void sync() throws IOException {
    //nothing
  }
}
