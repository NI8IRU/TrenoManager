const compagnia = document.getElementById('compagnia');

const defaultOption3 = document.createElement('option');
defaultOption3.text = 'Compagnia...';
defaultOption3.disabled = true;
defaultOption3.selected = true;
compagnia.appendChild(defaultOption3);

const compagnie = [
    'Freccia Rossa',
    'Trenord'
]

for (let i = 0; i < compagnie.length; i++) {
    const option = document.createElement('option');
    option.value = i;
    option.text = compagnie[i];
    compagnia.appendChild(option);
}