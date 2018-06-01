export class FormErrorMsgs {

    public required() {
        return 'Questo campo è OBBLIGATORIO';
    }

    public minLength(min: number) {
        if (min < 2) {
            return 'Questo campo deve contere almeno ' + min + ' carattere';
        }
        if (min >= 2) {
            return 'Questo campo deve contere almeno ' + min + ' caratteri';
        }
    }

    public maxLength(min: number) {
        return 'Questo campo deve contere almeno al massimo' + min + ' caratteri!';
    }

    public pattern() {
        return 'Ops, sembra che i dati non siano corretti! Prova a ricontrollare';
    }
}
