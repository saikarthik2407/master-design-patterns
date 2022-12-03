package learn.state_pattern;

/**
 * source: <a href="https://medium.com/swlh/behavioral-design-pattern-state-d908192fe7e"/>
 * The state pattern is one of the eleven current behavioral software design patterns.
 * It allows an object to change its behavior when its internal state changes.
 * This pattern makes it easy to change an object’s behavior without having to check the
 * current of the object with a conditional statement, which makes a codebase flexible,
 * testable and maintainable.
 * ------------Pattern Ideal Usage--------------
 * When should this pattern be used? Let’s say you’re in charge of designing a system that changes the input of an audio device.
 * There are multiple inputs we can change to but the switch happens in sequential order( e.g. Bluetooth, Optical, Coaxial,
 * RCA and USB). One input will always be selected.
 * This scenario would be a good use of the state pattern. It does not matter what’s being done underneath the hood of the audio
 * device, we just care that it changes from one input (state) to the next when we hit the switch button.
 * ------------Implementation------------
 * What would that look like in code? Each state would perform some work to transition to the new state — i.e. to switch from
 * Bluetooth → Optical → Coaxial → RCA → USB inputs.
 * Each one of these inputs is responsible for switching to the next one. Then there’s a context class that keeps track of the
 * current input and allows the switch to the next input.
 *
 */
public class StatePatternMedium {
    public static void main(String[] args) {
        InputContext inputContext = new InputContext();
        inputContext.changeState();
        inputContext.changeState();
        inputContext.changeState();
        inputContext.changeState();
        inputContext.changeState();
    }
}

class InputContext {
    InputState state;
    public InputContext() {
        state = BluetoothState.getInstance();
    }
    public void setState(InputState state) {
        this.state = state;
    }
    public InputState getState() {
        return this.state;
    }
    public void changeState() {
        this.state.changeInput(this);
    }
}

interface InputState {
    void changeInput(InputContext context);
}

class BluetoothState implements InputState {
    private BluetoothState() { }
    private static BluetoothState sInstance;
    public static BluetoothState getInstance() {
        if (sInstance == null) {
            sInstance = new BluetoothState();
            return sInstance;
        }
        return sInstance;
    }
    @Override
    public void changeInput(InputContext context) {
        System.out.println("Switching input to Optical...");
        context.setState(OpticalState.getInstance());
    }
}

class OpticalState implements InputState {
    private OpticalState() { }
    private static OpticalState sInstance;
    public static OpticalState getInstance() {
        if (sInstance == null) {
            sInstance = new OpticalState();
            return sInstance;
        }
        return sInstance;
    }
    @Override
    public void changeInput(InputContext context) {
        System.out.println("Switching input to Coaxial...");
        context.setState(CoaxialState.getInstance());
    }
}

class CoaxialState implements InputState {
    private CoaxialState() { }
    private static CoaxialState sInstance;
    public static CoaxialState getInstance() {
        if (sInstance == null) {
            sInstance = new CoaxialState();
            return sInstance;
        }
        return sInstance;
    }
    @Override
    public void changeInput(InputContext context) {
        System.out.println("Switching input to RCA...");
        context.setState(RCAState.getInstance());
    }
}

class RCAState implements InputState {
    private RCAState() { }
    private static RCAState sInstance;
    public static RCAState getInstance() {
        if (sInstance == null) {
            sInstance = new RCAState();
            return sInstance;
        }
        return sInstance;
    }
    @Override
    public void changeInput(InputContext context) {
        System.out.println("Switching input to USB...");
        context.setState(USBState.getInstance());
    }
}

class USBState implements InputState {
    private USBState() { }
    private static USBState sInstance;
    public static USBState getInstance() {
        if (sInstance == null) {
            sInstance = new USBState();
            return sInstance;
        }
        return sInstance;
    }
    @Override
    public void changeInput(InputContext context) {
        System.out.println("Switching input to Bluetooth...");
        context.setState(BluetoothState.getInstance());
    }
}