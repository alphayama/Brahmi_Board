package alphayama.brahmiboard;

import android.app.Service;
import android.content.Intent;
import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputConnection;

public class BrahmiBoard extends InputMethodService implements KeyboardView.OnKeyboardActionListener {

    private KeyboardView kbView;
    private Keyboard kb;

    @Override
    public View onCreateInputView() {
        kbView = (KeyboardView) getLayoutInflater().inflate(R.layout.keyboard,null);
        kb = new Keyboard(this,R.xml.brahmi);
        kbView.setKeyboard(kb);
        kbView.setOnKeyboardActionListener(this);
        return kbView;
    }

    @Override
    public void onPress(int primaryCode) {

    }

    @Override
    public void onRelease(int primaryCode) {

    }

    @Override
    public void onKey(int primaryCode, int[] keyCodes) {
        InputConnection ic = getCurrentInputConnection();
        switch (primaryCode){
            case Keyboard.KEYCODE_DELETE:
                ic.deleteSurroundingText(1,0);
                break;
            case Keyboard.KEYCODE_DONE:
                ic.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN,KeyEvent.KEYCODE_ENTER));
                break;
            default:
                //char code = (char) primaryCode;
                ic.commitText(String.valueOf(Character.toChars(primaryCode)),1);
        }
    }

    @Override
    public void onText(CharSequence text) {

    }

    @Override
    public void swipeLeft() {

    }

    @Override
    public void swipeRight() {

    }

    @Override
    public void swipeDown() {

    }

    @Override
    public void swipeUp() {

    }
}
