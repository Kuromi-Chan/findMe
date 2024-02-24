// Определение функции для обработки события выбора типа животного
function handlePetTypeChange() {
    document.querySelectorAll('input[name="petType"]').forEach((input) => {
        input.addEventListener('change', function() {
            if (this.checked) {
                document.getElementById('breedSelect').style.display = 'block';
                var petTypeId = this.value;
                var filteredBreeds = breeds.filter(breed => breed.petType.id === petTypeId);
                var breedSelect = document.getElementById('breedSelect');
                breedSelect.innerHTML = '';
                filteredBreeds.forEach(breed => {
                    var option = document.createElement('option');
                    option.value = breed.id;
                    option.text = breed.name;
                    breedSelect.appendChild(option);
                });
            } else {
                document.getElementById('breedSelect').style.display = 'none';
            }
        });
    });
}

// Вызов функции при загрузке страницы
document.addEventListener('DOMContentLoaded', function() {
    handlePetTypeChange();
});
