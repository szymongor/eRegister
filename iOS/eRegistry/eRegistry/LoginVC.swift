//
//  LoginVC.swift
//  eRegistry
//
//  Created by Kryg Tomasz on 10.04.2017.
//  Copyright © 2017 Kryg Tomek. All rights reserved.
//

import UIKit
import MBProgressHUD

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
    
    var indicator: MBProgressHUD?
    
    func onLoginClick() {
        showIndicator()
        let username = usernameTF.text ?? ""
        let password = passwordTF.text ?? ""
        RequestManager.login(username: username, password: password, completion: {
            success in
            
            self.hideIndicator()
            
            self.tryToRememberUser()
            
            if success {
                self.goToMenu()
            } else {
                self.showErrorAlert()
            }
        })
        
    }
    
    private func showIndicator() {
        indicator = MBProgressHUD.showAdded(to: self.view, animated: true)
        indicator?.label.text = "Logowanie"
        indicator?.contentColor = Colors.MAIN
    }
    
    private func hideIndicator() {
        indicator?.hide(animated: true)
    }
    
    private func tryToRememberUser() {
        if rememberMeCheckBox.isChecked {
            UserDefaultValues.rememberMe = true
        }
    }
    
    private func goToMenu() {
        guard let menuVC: MenuVC = UINib(nibName: "MenuVC", bundle: nil).instantiate(withOwner: self, options: nil).first as? MenuVC else {
            return
        }
        self.navigationController?.pushViewController(menuVC, animated: true)
    }
    
    private func showErrorAlert() {
        
        let alert = UIAlertController(title: "Błąd", message: "Sprawdź połączenie z internetem oraz wprowadź poprawne dane logowania.", preferredStyle: .alert)
        let action = UIAlertAction(title: "OK", style: .cancel, handler: {
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
        prepareNavigationBar()
        tryToLogIn()
    }
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)
        navigationController?.setNavigationBarHidden(true, animated: true)
    }
    
    override func viewWillDisappear(_ animated: Bool) {
        super.viewWillDisappear(animated)
        self.navigationController?.setNavigationBarHidden(false, animated: true)
    }
    
    private func prepareNavigationBar() {
        navigationController?.navigationBar.isTranslucent = false
        navigationController?.navigationBar.barTintColor = Colors.MAIN
        navigationController?.navigationBar.tintColor = .white
        navigationController?.navigationBar.titleTextAttributes = [NSForegroundColorAttributeName: UIColor.white]
    }
    
    private func tryToLogIn() {
        if UserDefaultValues.rememberMe {
            usernameTF.text = UserDefaultValues.username
            passwordTF.text = UserDefaultValues.password
            rememberMeCheckBox.buttonClicked(sender: rememberMeCheckBox)
            onLoginClick()
        }
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

