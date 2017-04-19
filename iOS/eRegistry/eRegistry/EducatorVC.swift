//
//  EducatorVC.swift
//  eRegistry
//
//  Created by Kryg Tomasz on 16.04.2017.
//  Copyright © 2017 Kryg Tomek. All rights reserved.
//

import UIKit

class EducatorVC: UIViewController {

    @IBOutlet weak var container: UIView! {
        didSet {
            container.backgroundColor = Colors.MAIN
        }
    }
    @IBOutlet weak var tableView: UITableView! {
        didSet {
            let cellNib = UINib(nibName: CELL_ID, bundle: nil)
            tableView.register(cellNib, forCellReuseIdentifier: CELL_ID)
            tableView.delegate = self
            tableView.dataSource = self
            tableView.rowHeight = UITableViewAutomaticDimension
            tableView.estimatedRowHeight = 44
        }
    }
    
    let CELL_ID = "EducatorTVCell"

    typealias EducatorDataTupple = (type: EducatorDataType, description: String)
    var educatorDatas: [EducatorDataTupple] = []
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.title = "Wychowawca"
        // Do any additional setup after loading the view.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

    func setView(for educator: Educator) {
        educatorDatas.append((.surname, educator.surname))
        educatorDatas.append((.name, educator.name))
        educatorDatas.append((.phone, educator.phone))
        educatorDatas.append((.email, educator.email))
        tableView.reloadData()
    }

}

// MARK: - TableView Delegate and DataSource

extension EducatorVC: UITableViewDelegate, UITableViewDataSource {
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        guard let cell: EducatorTVCell = tableView.dequeueReusableCell(withIdentifier: CELL_ID, for: indexPath) as? EducatorTVCell else {
            return UITableViewCell()
        }
        let data = educatorDatas[indexPath.row]
        cell.setView(type: data.type, description: data.description)
        return cell
    }
    
    func numberOfSections(in tableView: UITableView) -> Int {
        return 1
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return educatorDatas.count
    }
    
    func tableView(_ tableView: UITableView, didHighlightRowAt indexPath: IndexPath) {
        return
    }
    
    func tableView(_ tableView: UITableView, didUnhighlightRowAt indexPath: IndexPath) {
        return
    }
    
}
