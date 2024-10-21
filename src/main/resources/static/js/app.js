document.getElementById('fileForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const fileInput = document.getElementById('fileInput');
    const methodSelect = document.getElementById('methodSelect');
    const resultDiv = document.getElementById('result');

    const formData = new FormData();
    formData.append('file', fileInput.files[0]);
    formData.append('method', methodSelect.value);

    fetch('/process', {
        method: 'POST',
        body: formData
    })
        .then(response => response.text())
        .then(result => {
            resultDiv.textContent = result;
        })
        .catch(error => {
            console.error('Error:', error);
            resultDiv.textContent = '处理失败';
        });
});