import * as React from 'react';
import { Game } from './Game';

interface IAddGameDataState {
    count:number,  
    game:Game,
    gameList: Game[];
    totalDraw: number,    
    totalRoundPlayed:number,
    totalWinsForFirstPlayer: number,
    totalWinsForSecondPlayer:number
}  

const outcome = {
    paper: 2,
    rock: 3,
    scissor: 1
}

class GameConsole extends React.Component<{}, IAddGameDataState> {

    public constructor(props: any) {
        super(props);
        this.state = {
            count: 0,
            game: {
                outcomeOne:0,
                outcomeTwo:0,
                result:0
            },
            gameList:[],
            totalDraw:0,
            totalRoundPlayed:0,
            totalWinsForFirstPlayer:0,
            totalWinsForSecondPlayer:0 
        };
        
        this.playRound = this.playRound.bind(this);
        this.restartGame = this.restartGame.bind(this);
        this.fetchApi(this.setGame)
    }

    public getRandomOutcome(){
        const rand = 1 + Math.random() * (3);
        return Math.trunc(rand)
    }

    public fetchApi(f: (data:Game)=>void){
        fetch('http://localhost:8080/play/outcomeone/'+ this.getRandomOutcome() + '/outcometwo/' + outcome.rock)  
            .then(response => response.json() as Promise<Game>)  
            .then(data => f(data));  
    }
    
    public setGame = (data:Game) => {  this.setState({ game: data }); };

    public setGameAndCount = (data:Game) => {  
                this.setState({ 
                    count: this.state.count+1,
                    game: data, 
                    totalRoundPlayed:this.state.totalRoundPlayed+1 
                }); 
            }

    public playRound() {

        this.fetchApi(this.setGameAndCount)

        if(this.state.game.result === 1){
            this.setState({totalWinsForFirstPlayer: this.state.totalWinsForFirstPlayer+1})
        }
        else if(this.state.game.result === 2){
            this.setState({totalWinsForSecondPlayer: this.state.totalWinsForSecondPlayer+1})
        }
        else{
            this.setState({totalDraw: this.state.totalDraw+1})
        }

        this.state.gameList.push(this.state.game);
    }

    public restartGame() {
        this.setState({gameList: [], count: 0})
    }

    public getResultMessage(result:number){
        if(result === 0){
            return 'draw'
        }
        return 'player ' + result + ' win'
    }

    public getOutcomeName(outcomeNumValue:number){
        
        if(outcomeNumValue === outcome.paper){
            return 'PAPER'
        }
        else if(outcomeNumValue === outcome.rock){
            return 'ROCK'
        }
        else if(outcomeNumValue === outcome.scissor){
            return 'SCISSOR'
        }

        return 'UNDEFINED'
    }

    public render() {

        return (<div>

                <style>{`
                    table {
                    font-family: arial, sans-serif;
                    border-collapse: collapse;
                    width: 100%;
                    }

                    td, th {
                    border: 1px solid #dddddd;
                    text-align: left;
                    padding: 8px;
                    }

                    tr:nth-child(even) {
                    background-color: #dddddd;
                    }
                `}</style>


                <h2>Game List</h2>
                
                <button name = "PlayRound" onClick={this.playRound}>Play Round</button>
                <button name = "Restart Game" onClick={this.restartGame}>Restart Game</button>

                <div>
                    Rounds: {this.state.count}
                </div>

                <div>
                    <table>
                            <tbody>    
                                <tr key="1">  
                                    <td>Total Round Played: {this.state.totalRoundPlayed}</td>  
                                </tr>  
                                <tr key="2">  
                                    <td>Total wins for first player: {this.state.totalWinsForFirstPlayer}</td>  
                                </tr>  
                                <tr key="3">  
                                    <td>Total wins for second player: {this.state.totalWinsForSecondPlayer}</td>  
                                </tr>  
                                <tr key="4">  
                                    <td>Total draw: {this.state.totalDraw}</td>  
                                </tr>  
                            </tbody>  
                    </table>
                </div>
                    <table className='table'>
                        <thead>  
                            <tr>  
                                <th/>  
                                <th>1st Player</th>  
                                <th>2nd Player</th>  
                                <th>result</th>  
                            </tr>  
                        </thead>
                        <tbody>  
                                {this.state.gameList.map(g =>  
                                    <tr key="1">  
                                        <td/>  
                                        <td>{this.getOutcomeName(g.outcomeOne)}</td>
                                        <td>{this.getOutcomeName(g.outcomeTwo)}</td>  
                                        <td>{this.getResultMessage(g.result)}</td>  
                                    </tr>  
                                )}  

                        </tbody>  
                    </table>
                </div>);
    }

}
export default GameConsole;