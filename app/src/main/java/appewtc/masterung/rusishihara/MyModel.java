package appewtc.masterung.rusishihara;

/**
 * Created by masterUNG on 4/25/15 AD.
 */
public class MyModel {

    private int intButton;

    public interface OnMyModelChangeListener {
        void onMyModelChangeListener(MyModel myModel);
    }

    private OnMyModelChangeListener onMyModelChangeListener;

    public void setOnMyModelChangeListener(OnMyModelChangeListener onMyModelChangeListener) {
        this.onMyModelChangeListener = onMyModelChangeListener;
    }

    public int getIntButton() {
        return intButton;
    }

    public void setIntButton(int intButton) {
        this.intButton = intButton;

        if (this.onMyModelChangeListener != null) {
            this.onMyModelChangeListener.onMyModelChangeListener(this);
        }

    }
}   // Main Class
