import React, { useEffect, useState } from 'react';

function App() {
  const [message, setMessage] = useState('');

  useEffect(() => {
    fetch('http://localhost:8085/api/simple/hello')
        .then(response => response.text())
        .then(data => {
          setMessage(data);
        })
        .catch(error => {
          console.error('Error fetching data: ', error);
          setMessage('Error fetching data');
        });
  }, []);

  return (
      <div className="App">
        <header className="App-header">
          <p>API Response: {message}</p>
        </header>
      </div>
  );
}

export default App;