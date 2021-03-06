package magpiebridge.core.analysis.configuration;

import java.util.ArrayList;
import java.util.List;
import magpiebridge.core.Analysis;

/**
 * This class defines a configuration option for a {@link Analysis} running at the server.
 *
 * @author Linghui Luo
 */
public class ConfigurationOption {

  private final String name;
  private final OptionType type;
  private List<ConfigurationOption> children;
  private String value;
  private String source;

  public ConfigurationOption(String name, OptionType type) {
    this.name = name;
    this.type = type;
  }

  public ConfigurationOption(String name, OptionType type, String defaultValue) {
    this(name, type);
    this.value = defaultValue;
  }

  public String getName() {
    return name;
  }

  public OptionType getType() {
    return type;
  }

  public ConfigurationOption addChild(ConfigurationOption... options) {
    if (children == null) children = new ArrayList<ConfigurationOption>();
    for (ConfigurationOption o : options) this.children.add(o);
    return this;
  }

  public boolean hasChildren() {
    return children != null && !children.isEmpty();
  }

  public List<ConfigurationOption> getChildren() {
    return children;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  public boolean getValueAsBoolean() {
    return "on".equals(value) || "true".equals(value);
  }

  public String getSource() {
    return source;
  }

  public ConfigurationOption setSource(String source) {
    this.source = source;
    if (children != null) for (ConfigurationOption o : children) o = o.setSource(source);
    return this;
  }

  @Override
  public String toString() {
    return "ConfigurationOption [name="
        + name
        + ", type="
        + type
        + ", children="
        + children
        + ", value="
        + value
        + ", source="
        + source
        + "]";
  }
}
