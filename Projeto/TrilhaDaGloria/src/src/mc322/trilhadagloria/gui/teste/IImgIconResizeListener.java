public interface IImgIconResizeListener extends IResizeListener {

    public abstract int getIconWidth();

    public abstract int getIconHeight();

    default public int getWidth() {
        return getIconWidth();
    }

    default public int getHeight() {
        return getIconHeight();
    }

}