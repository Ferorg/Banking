package banking.service;

import banking.objeckt.OperationsHistory;
import banking.objeckt.Account;
import banking.objeckt.Users;

import java.io.*;
import java.util.*;

public class SerializableAndDesirializable {
    public void serializableUsers(List<Users> usersList) {
        String file = "src/banking/repository/UsersList.txt";
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            objectOutputStream.writeObject(usersList);
            objectOutputStream.close();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public List<Users> deserializeUsers() {
        String file = "src/banking/repository/UsersList.txt";
        List<Users> usersList = new ArrayList<>();
        try (ObjectInputStream objectInputputStream = new ObjectInputStream(new FileInputStream(file))) {
            usersList = (List<Users>) objectInputputStream.readObject();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return usersList;
    }

    public void serializableCurrency(Map<String, Double> currency) {
        String file = "src/banking/repository/KursList.txt";
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            objectOutputStream.writeObject(currency);
            objectOutputStream.close();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public Set<Map.Entry<String, Double>> deserializeCurrency() {
        String file = "src/banking/repository/KursList.txt";
        Map<String, Double> currency = new HashMap<>();
        try (ObjectInputStream objectInputputStream = new ObjectInputStream(new FileInputStream(file))) {
            currency = (Map<String, Double>) objectInputputStream.readObject();
            objectInputputStream.close();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        Set<Map.Entry<String, Double>> entrySet = currency.entrySet();
        return entrySet;
    }

    public List<Account> serializableAccount(List<Account> accountList) {
        String file = "src/banking/repository/AccountList.txt";
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            objectOutputStream.writeObject(accountList);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return accountList;
    }

    public List<Account> deserializeAccount() {
        String file = "src/banking/repository/AccountList.txt";
        List<Account> accountList = new ArrayList<>();
        try (ObjectInputStream objectInputputStream = new ObjectInputStream(new FileInputStream(file))) {
            accountList = (List<Account>) objectInputputStream.readObject();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return accountList;
    }

    public List<OperationsHistory> serializableOperation(List<OperationsHistory> operationsHistories) {
        String file = "src/banking/repository/OperationsHistory.txt";
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            objectOutputStream.writeObject(operationsHistories);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return operationsHistories;
    }

    public List<OperationsHistory> deserializeOperations() {
        String file = "src/banking/repository/OperationsHistory.txt";
        List<OperationsHistory> historyList = new ArrayList<>();
        try (ObjectInputStream objectInputputStream = new ObjectInputStream(new FileInputStream(file))) {
            historyList = (List<OperationsHistory>) objectInputputStream.readObject();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return historyList;
    }

    public List<Double> serializableCommisions(List<Double> peny) {
        String file = "src/banking/repository/Commissions.txt";
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            objectOutputStream.writeObject(peny);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return peny;
    }

    public List<Double> deserializeCommisions() {
        String file = "src/banking/repository/Commissions.txt";
        List<Double> comissions = new ArrayList<>();
        try (ObjectInputStream objectInputputStream = new ObjectInputStream(new FileInputStream(file))) {
            comissions = (List<Double>) objectInputputStream.readObject();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return comissions;
    }

    public Map<String, Double> deserializeCurrencyDop() {
        String file = "src/banking/repository/KursList2.txt";
        Map<String, Double> map = new HashMap<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            String[] arr = line.split(",");
            for (String s : arr) {
                String[] keyValue = s.split("=");
                map.put(keyValue[0], Double.valueOf(keyValue[1]));
            }
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return map;
    }


}
