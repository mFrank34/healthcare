package Controllers;

import Interface.Validator;
import Views.BaseForm;
import java.util.List;

public abstract class BaseController<T> {
    protected final BaseForm view;
    protected final T model;
    protected final Validator<T> validator;

    public BaseController(BaseForm view, T model, Validator<T> validator) {
        this.view = view;
        this.model = model;
        this.validator = validator;
    }

    protected void handleSubmit() {
        List<String> errors = validator.validate(model);
        if (!errors.isEmpty()) {
            view.showErrors(errors);
        } else {
            saveModel();
        }
    }

    protected abstract void saveModel();
}

