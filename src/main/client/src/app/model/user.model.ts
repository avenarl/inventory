export class User{
    uid: number;
    username: string;
    password: string;

    constructor(uid: number, username: string, password: string){
        this.uid = uid;
        this.username = username;
        this.password = password;
    }
}