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
            usernameTF.text = ""
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
    @IBOutlet weak var roleTF: UITextField! {
        didSet {
            roleTF.delegate = self
            roleTF.placeholder = "Wybierz rolę"
            roleTF.appTheme()
        }
    }
    
    override var preferredStatusBarStyle: UIStatusBarStyle {
        return .default
    }
    
    var possibleRoles = ["---", "Uczeń", "Nauczyciel", "Opiekun"]
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
                
                self.tryGoToMenu(type: User.instance.roleType)
            } else {
                self.showErrorAlert(message: "Sprawdź połączenie z internetem oraz wprowadź poprawne dane logowania.")
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
            User.instance.rememberMe = true
        }
    }
    
    private func tryGoToMenu(type: UserType) {
        guard let menuVC: MenuVC = UINib(nibName: "MenuVC", bundle: nil).instantiate(withOwner: self, options: nil).first as? MenuVC else {
            return
        }
        if type != .undefined {
            menuVC.prepare(for: type)
            self.navigationController?.pushViewController(menuVC, animated: true)
        } else {
            showErrorAlert(message: "Podany typ użytkownika nie jest wspierany przez aplikację mobliną.")
        }
    }
    
    private func showErrorAlert(message: String) {
        
        let alert = UIAlertController(title: "Błąd", message: message, preferredStyle: .alert)
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
        setNeedsStatusBarAppearanceUpdate()
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        prepareNavigationBar()
        tryToLogIn()
        //setNeedsStatusBarAppearanceUpdate()
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
        UIApplication.shared.statusBarStyle = .lightContent
        navigationController?.navigationBar.isTranslucent = false
        navigationController?.navigationBar.barTintColor = Colors.MAIN
        navigationController?.navigationBar.tintColor = Colors.SECOND_APP_COLOR
        navigationController?.navigationBar.titleTextAttributes = [NSForegroundColorAttributeName: Colors.SECOND_APP_COLOR]
    }
    
    private func tryToLogIn() {
        if User.instance.rememberMe {
            usernameTF.text = User.instance.username
            passwordTF.text = User.instance.password
            rememberMeCheckBox.buttonClicked(sender: rememberMeCheckBox)
            onLoginClick()
        }
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

extension LoginVC: UITextFieldDelegate {
    func textFieldDidBeginEditing(_ textField: UITextField) {
        //self.view.endEditing(true)
        var pickerView = UIPickerView()
        pickerView.delegate = self
        pickerView.dataSource = self
        textField.inputView = pickerView
    }
}

extension LoginVC: UIPickerViewDelegate, UIPickerViewDataSource {
    
    func numberOfComponents(in pickerView: UIPickerView) -> Int {
        return 1
    }
    
    func pickerView(_ pickerView: UIPickerView, numberOfRowsInComponent component: Int) -> Int {
        return possibleRoles.count
    }
    
    func pickerView(_ pickerView: UIPickerView, titleForRow row: Int, forComponent component: Int) -> String? {
        return possibleRoles[row]
    }
    
    func pickerView(_ pickerView: UIPickerView, didSelectRow row: Int, inComponent component: Int) {
        if possibleRoles[row] == "---" {
            pickerView.selectRow(1, inComponent: 0, animated: true)
            roleTF.text = possibleRoles[1]
        } else {
            roleTF.text = possibleRoles[row]
        }
        roleTF.resignFirstResponder()
    }
    
}
