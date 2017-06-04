package codes.chia7712.hellodb;

/**
 *
 * @author hsinying
 */
public enum CommandEnum {
  CREATE_TABLE(1),
  DELETE_TABLE(2),
  INSERT_CELL(3),
  INSERT_CELL_IF_ANSENT(4),
  DELETE_CELL(5),
  DELETE_CELLS_BY_ROW(6);
  private final int id;

  CommandEnum(int id) {
    this.id = id;
  }

  public int getInt() {
    return id;
  }

  public static CommandEnum getEnum(int id) {
    for (CommandEnum e : CommandEnum.values()) {
      if (e.id == id) {
        return e;
      }
    }
    return null;
  }
}
