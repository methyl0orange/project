import java.util.List;

public class ParentNode {
    private String name;
    private boolean open;
    private List<SonNode> children;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public List<SonNode> getChildren() {
        return children;
    }

    public void setChildren(List<SonNode> children) {
        this.children = children;
    }

    public ParentNode(String name, boolean open, List<SonNode> children) {
        this.name = name;
        this.open = open;
        this.children = children;
    }
}
