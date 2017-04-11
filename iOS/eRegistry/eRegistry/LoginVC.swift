//
//  LoginVC.swift
//  eRegistry
//
//  Created by Kryg Tomasz on 10.04.2017.
//  Copyright © 2017 Kryg Tomek. All rights reserved.
//

import UIKit

class LoginVC: UIViewController {

    @IBOutlet weak var appImageView: UIImageView! {
        didSet {
            appImageView.image = #imageLiteral(resourceName: "logoIcon")
        }
    }
    @IBOutlet weak var usernameTF: UITextField! {
        didSet {
            usernameTF.placeholder = "Login"
            usernameTF.text = "Bartosz"
            usernameTF.appTheme()
        }
    }
    @IBOutlet weak var passwordTF: UITextField! {
        didSet {
            passwordTF.placeholder = "Hasło"
            passwordTF.text = "12345678"
            passwordTF.appTheme()
        }
    }
    @IBOutlet weak var loginButton: UIButton! {
        didSet {
            loginButton.setTitle("Zaloguj", for: .normal)
            loginButton.appTheme()
            loginButton.addTarget(self, action: #selector(onLoginClick), for: .touchUpInside)
        }
    }
    @IBOutlet weak var rememberMeLabel: UILabel! {
        didSet {
            rememberMeLabel.text = "Zapamiętaj mnie"
            
            let tapGesture = UITapGestureRecognizer(target: self, action: #selector(onRememberMeClick))
            rememberMeLabel.addGestureRecognizer(tapGesture)
            rememberMeLabel.isUserInteractionEnabled = true
        }
    }
    @IBOutlet weak var rememberMeCheckBox: CheckBox!
    
    func onLoginClick() {
        
        let username = usernameTF.text ?? ""
        let password = passwordTF.text ?? ""
        RequestManager.login(username: username, password: password, completion: {
            success in
            if success {
                
                guard let menuVC: MenuVC = UINib(nibName: "MenuVC", bundle: nil).instantiate(withOwner: self, options: nil).first as? MenuVC else {
                    return
                }
                let _ = self.navigationController?.popToRootViewController(animated: true)
                self.navigationController?.setViewControllers([menuVC], animated: true)
            } else {
                self.showAlert()
            }
        })
        
    }
    
    private func showAlert() {
        
        let alert = UIAlertController(title: "Błąd!", message: "Albo neta nie ma albo se hasło gdzieś zapisz jak nie pamiętasz.", preferredStyle: .alert)
        let action = UIAlertAction(title: "Przepraszam...", style: .cancel, handler: {
            _ in
            alert.dismiss(animated: true, completion: nil)
        })
        alert.addAction(action)
        self.present(alert, animated: true, completion: nil)
        
    }
    
    func onRememberMeClick() {
        rememberMeCheckBox.buttonClicked(sender: rememberMeCheckBox)
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

