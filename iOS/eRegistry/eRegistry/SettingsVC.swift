//
//  SettingsVC.swift
//  eRegistry
//
//  Created by Kryg Tomasz on 14.04.2017.
//  Copyright © 2017 Kryg Tomek. All rights reserved.
//

import UIKit

class SettingsVC: UIViewController {

    @IBOutlet weak var tableView: UITableView! {
        didSet {
            let cellNib = UINib(nibName: CELL_ID, bundle: nil)
            tableView.register(cellNib, forCellReuseIdentifier: CELL_ID)
            tableView.delegate = self
            tableView.dataSource = self
        }
    }
    @IBOutlet weak var bottomView: UIView! {
        didSet {
            bottomView.backgroundColor = Colors.MAIN
        }
    }
    @IBOutlet weak var userInfoLabel: UILabel! {
        didSet {
            userInfoLabel.textColor = Colors.SECOND_APP_COLOR
            userInfoLabel.text = "Zalogowano jako: \(User.instance.username)"
        }
    }
    
    let CELL_ID = "SettingsTVCell"
    
    var settingsItems: [SettingsItemModel] = []
    
    override func viewDidLoad() {
        super.viewDidLoad()

        self.title = "Informacje"
        
        settingsItems.append(SettingsItemModel(image: #imageLiteral(resourceName: "lockIcon"), description: "Hasło", type: .password))
        settingsItems.append(SettingsItemModel(image: #imageLiteral(resourceName: "phoneIcon"), description: "Telefon", type: .phone))
        settingsItems.append(SettingsItemModel(image: #imageLiteral(resourceName: "messageIcon"), description: "E-mail", type: .email))
        settingsItems.append(SettingsItemModel(image: #imageLiteral(resourceName: "homeIcon"), description: "Adres", type: .address))
        // Do any additional setup after loading the view.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

}

// MARK: UITableView protocols

extension SettingsVC: UITableViewDelegate, UITableViewDataSource {
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        guard let cell = tableView.dequeueReusableCell(withIdentifier: CELL_ID, for: indexPath) as? SettingsTVCell else {
            return UITableViewCell()
        }
        cell.setModel(settingsItems[indexPath.row])
        return cell
    }
    
    func numberOfSections(in tableView: UITableView) -> Int {
        return 1
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return settingsItems.count
    }
    
    
    func tableView(_ tableView: UITableView, titleForHeaderInSection section: Int) -> String? {
        return "Dane użytkownika:"
    }
    
    func tableView(_ tableView: UITableView, titleForFooterInSection section: Int) -> String? {
        let roleName = User.instance.roleName
        let footer = "Typ konta: " + roleName
        return footer
    }
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        let type = settingsItems[indexPath.row].type
        goToForm(ofType: type)
        tableView.deselectRow(at: indexPath, animated: true)
    }
    
    private func goToForm(ofType type: SettingType) {
        guard let formVC = UINib(nibName: "FormVC", bundle: nil).instantiate(withOwner: self, options: nil).first as? FormVC else {
            return
        }
        formVC.setType(type)
        navigationController?.pushViewController(formVC, animated: true)
    }
    
}
