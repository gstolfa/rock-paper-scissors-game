import * as React from 'react';
import './App.css';
import GameConsole from './GameConsole';
import logo from './logo.svg';


class App extends React.Component<{}, any> {
  public render() {
    return (
      <div className="App">
        <div className="App-header">
          <img src={logo} className="App-logo" alt="logo"/>
          <h2>Rock Paper Scissor Game</h2>
        </div>

        <GameConsole/>
      
      </div>
    );
  }
}

export default App;
